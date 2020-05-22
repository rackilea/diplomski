<!--- create mapping to javaloder --->
<cfscript>        
    THIS.mappings["/javaloader"] = GetDirectoryFromPath( GetCurrentTemplatePath() ) & "tools/javaloader";
</cfscript>

<!--- Application start --->
<cffunction name="onApplicationStart" returnType="boolean" output="false" hint="">
    <cfscript>       
        <!--- store a UUID and emptry path array in Application scope --->
        Application.str = structNew(); 
        Application.str.myJavaLoaderKey = "your_uuid_javaloader";
        Application.str.jarPaths = arrayNew(1);
    </cfscript>
     <!--- check if exists --->
    <cfif ( NOT structKeyExists(server, Application.str.myJavaLoaderKey) )>

         <!--- put all paths to your .java files here, this is for JBCrypt --->
         <cfset Application.str.jarPaths[1] = expandPath("/classes/jBCrypt-0.3")>
         <cfif ( NOT structKeyExists(server, Application.str.myJavaLoaderKey) )>

            <cflock name="#Hash(Application.str.myJavaLoaderKey)#" type="exclusive" timeout="10">
                <!--- create javaloader object and init with all submitted paths --->
                <cfset server[Application.str.myJavaLoaderKey] = createObject("component", "javaloader.JavaLoader").init(sourceDirectories=Application.str.jarPaths )>
            </cflock>
        </cfif>
    </cfif>
</cffunction>
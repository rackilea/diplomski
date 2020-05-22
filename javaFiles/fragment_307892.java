<target name="init">
   <echo message="Java Version: ${java.version}"/>
   <echo message="Java home: ${java.home}"/>
   <fail message="Unsupported Java version: ${java.version}. Make sure that the version of the Java compiler is 1.7 (7.0) or greater.">
     <condition>
      <not>
         <or>
           <contains string="${java.version}" substring="1.7" casesensitive="false"/>
           <contains string="${java.version}" substring="1.8" casesensitive="false"/>
         </or>
      </not>
     </condition>
   </fail>
</target>
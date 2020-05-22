<concat destfile="${docbook.dir}/all-sections.xml" force="no">       
    <fileset dir="${docbook.dir}" includes="sections/*.xml"/>
    <filterchain>
        <linecontainsregexp negate="true">
            <regexp pattern="&lt;\?xml version"/>
        </linecontainsregexp>
    </filterchain>  
 </concat>
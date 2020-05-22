<jar destfile="${generated.jars.dir}/hello-${environment}.jar">
    <fileset dir="${generated.classes.dir}"/>
    <zipfileset dir="${environment.dir}/${environment}" 
                includes="config.xml"
                fullpath="database/config.xml"/>
</jar>
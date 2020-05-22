<jar destfile="${out.library.jar.file}">                        
       <fileset dir="${out.classes.absolute.dir}"
         includes="**/*.class"
         excludes="${project.app.package.path}/R.class ${project.app.package.path}/R$*.class ${project.app.package.path}/Manifest.class ${project.app.package.path}/Manifest$*.class ${project.app.package.path}/BuildConfig.class"/>
       <fileset dir="${source.absolute.dir}" excludes="**/*.java ${android.package.excludes}" />
   </jar>
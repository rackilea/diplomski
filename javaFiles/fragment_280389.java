<war destfile="${deploy.dir}/vms_war.war" webxml="${web.dir}/WEB-INF/web.xml">
  <classes dir="${classes.dir}" />
  <fileset dir="${src.dir}">
    <include name="**/*.xml"/>
  </fileset>
  <fileset dir="${web.dir}">
    <include name="**/*.jspx"/>
    <include name="**/*.jsp"/>
    <include name="**/*.html"/>                        
    <include name="WEB-INF/*.xml"/>
    <include name="WEB-INF/lib/*.*"/>
    <exclude name="**/web.xml"/>
  </fileset>
</war>
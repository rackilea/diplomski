<war destfile="${build.dir}/CrunchifyRESTJerseyExample.war" webxml="WebContent/WEB-INF/web.xml">
    <classes dir="${build.dir}"/>
    <lib dir="${lib.dir}">
       <exclude name="jdbc1.jar"/>  <!-- Exclude here jars you don't want -->
    </lib>
</war>
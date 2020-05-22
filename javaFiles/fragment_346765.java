<ivy:retrieve pattern="${build.dir}/lib/[artifact].[ext]">
  <dependency org="org.glassfish" name="javax.json" rev="1.0.4" />
  <dependency org="org.glassfish.jersey.containers" name="jersey-container-servlet" rev="2.23.2" />    
</ivy:retrieve>

<war destfile="${war.file}" webxml="${resources.dir}/web.xml">
    <fileset dir="${resources.dir}" excludes="web.xml"/>
    <lib dir="${build.dir}/lib"/>
</war>
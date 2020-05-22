<?xml version="1.0"?>
<project name="jspc" basedir="." default="all">
 <import file="${build.appserver.home}/bin/catalina-tasks.xml"/>

 <target name="all" depends="jspc,compile"></target>

 <target name="jspc">
  <jasper
   validateXml="false"
   uriroot="${build.war.dir}"
   webXmlFragment="${build.war.dir}/WEB-INF/generated_web.xml"
   addWebXmlMappings="true"
   outputDir="${build.src.dir}" />
 </target>

 <target name="compile">
  <javac destdir="${build.dir}/classes"
   srcdir="${build.src.dir}"
   optimize="on"
   debug="off"
   failonerror="true"
   source="1.5"
   target="1.5"
   excludes="**/*.smap">
   <classpath>
    <fileset dir="${build.war.dir}/WEB-INF/classes">
     <include name="*.class" />
    </fileset>
    <fileset dir="${build.war.lib.dir}">
     <include name="*.jar" />
    </fileset>
    <fileset dir="${build.appserver.home}/lib">
     <include name="*.jar" />
    </fileset>    
    <fileset dir="${build.appserver.home}/bin">
     <include name="*.jar"/>
    </fileset>
   </classpath>
    <include name="**" />
    <exclude name="tags/**"/>
  </javac>
 </target>

 <target name="clean">
  <delete>
   <fileset dir="${build.src.dir}"/>
   <fileset dir="${build.dir}/classes/org/apache/jsp"/>
  </delete>
 </target>
</project>
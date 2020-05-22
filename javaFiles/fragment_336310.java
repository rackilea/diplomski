<path id="weblogic.lib.path">
  <fileset file="${weblogic.classpath.id}"/>
</path>

<taskdef name="wlst" classname="weblogic.ant.taskdefs.management.WLSTTask" 
                     classpathref="weblogic.lib.path" />
<target name="startTomcat_DebugLinux" if="isLinux">
  <exec executable="gnome-terminal" spawn="true">
    <arg line="--window-with-profile=Tomcat --geometry=120x60 -e '${env.CATALINA_HOME}/bin/catalina.sh jpda run'" />
  </exec>
</target>

<target name="startTomcat_DebugMac" if="isMac">
  <exec executable="/usr/X11R6/bin/xterm" spawn="true">
    <arg  line="-geometry 180x65 -e ${env.CATALINA_HOME}/bin/catalina.sh jpda run" />
  </exec>
</target>
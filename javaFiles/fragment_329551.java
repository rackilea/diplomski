<target name="javadoc">
    <javadoc destdir="${javadoc}"
         encoding="US-ASCII"
         charset="UTF-8"
         docencoding="UTF-8"
         use="yes"
         windowtitle="JSch API"
             sourcepath="${src}"
         >
      <arg value="-notimestamp" />
      <package name="com.jcraft.jsch" />
      <doctitle>JSch – Java Secure Channel ${version}</doctitle>
      <bottom>This is an inofficial Javadoc created by Paŭlo Ebermann.
    Have a look at the &lt;a href="http://www.jcraft.com/jsch/">official homepage&lt;/a>.
      </bottom>
      <link href="http://download.oracle.com/javase/6/docs/api/" />
    </javadoc>
  </target>
<target name="simple.javadoc">
    <javadoc destdir="${simple.javadoc}"
             encoding="US-ASCII"
             charset="UTF-8"
             docencoding="UTF-8"
             use="yes"
             windowtitle="simple JSch API"
             excludepackagenames="*"
             sourcepath="${src}"
             >
      <arg value="-notimestamp" />
      <sourcefiles>
        <resourcelist encoding="US-ASCII">
          <file file="simpleclasses.list" />
        </resourcelist>
      </sourcefiles>
      <doctitle>JSch – Java Secure Channel ${version} (simplified version)</doctitle>
      <bottom>This is a simplified version of the &lt;a href="http://epaul.github.com/jsch-documentation/javadoc/">inofficial Javadoc&lt;/a> created by Paŭlo Ebermann.
        Have a look at the &lt;a href="http://www.jcraft.com/jsch/">official homepage&lt;/a>.
      </bottom>
      <link href="http://download.oracle.com/javase/6/docs/api/" />
    </javadoc>
  </target>
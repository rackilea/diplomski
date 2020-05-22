<!-- workaround bug https://netbeans.org/bugzilla/show_bug.cgi?id=198480 -->
<target name="checkos">
    <echo message="OS Name is:         ${os.name}"/>
    <echo message="OS Architecture is: ${os.arch}"/>
    <echo message="OS Version is:      ${os.version}"/>
    <condition property="is_windows">
        <os family="windows"/>
    </condition>
    <condition property="is_linux">
        <os family="unix"/>
    </condition>
</target>
<target name="patch-bug-198480-windows" if="is_windows" depends="checkos">
    <copy file="lib/nblibraries-syscp-windows.properties" tofile="lib/nblibraries-private.properties"/>
</target>
<target name="patch-bug-198480-linux" if="is_linux" depends="checkos">
    <copy file="lib/nblibraries-syscp-linux.properties" tofile="lib/nblibraries-private.properties"/>
</target>

<target name="-post-clean">
    <delete file="lib/nblibraries-private.properties"/>
</target>

    <target name="-pre-init" depends="patch-bug-198480-windows,patch-bug-198480-linux">
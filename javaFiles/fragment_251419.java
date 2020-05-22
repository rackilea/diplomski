<target name="insert-filesize">
    <length file="${afile}" property="fs.length.bytes" />

    <script language="javascript">
    <![CDATA[
        var length_bytes = project.getProperty("fs.length.bytes");
        var length_kbytes = Math.round((length_bytes / 1024) * Math.pow(10,2))
                          / Math.pow(10,2);
        var length_mbytes = Math.round((length_kbytes / 1024) * Math.pow(10,2))
                          / Math.pow(10,2);
        project.setNewProperty("fs.length.kb", length_kbytes);
        project.setNewProperty("fs.length.mb", length_mbytes);
    ]]>
    </script>

    <copy todir="${target.dir}">
        <fileset dir="${source.dir}">
            <include name="**/*" />
            <exclude name="**/*.zip" />
        </fileset>
        <filterset begintoken="$$$$" endtoken="$$$$">
            <filter token="SIZEBYTES" value="${fs.length.bytes}"/>
            <filter token="SIZEKILOBYTES" value="${fs.length.kb}"/>
            <filter token="SIZEMEGABYTES" value="${fs.length.mb}"/>
        </filterset>
    </copy>
</target>
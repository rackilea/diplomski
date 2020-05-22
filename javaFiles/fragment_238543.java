<target name="messages">
    <for param="wsdl.file">
        <fileset dir="${base.wsdl.src}">
            <include name="*.wsdl" />
        </fileset>
        <sequential>
            <echo message="@{wsdl.file}" />  <!-- Note "@" and not "$" -->
        </sequential>
    </for>
</target>
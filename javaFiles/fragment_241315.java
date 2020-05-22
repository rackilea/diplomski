<one-jar destfile="libraryWithNativeCode.jar">
    <manifest>
        <attribute name="One-Jar-Main-Class" value="${main.class}"/>
    </manifest>

    <main jar="libraryWithoutNativeCode.jar" />

    <binlib>
        <fileset dir="${bin.dir}" includes="rxtxSerial.dll"/>
    </binlib>
</one-jar>
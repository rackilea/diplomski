<structure name="Example Project">
    <group name="Server">
        <classfiles>
            <fileset dir="${workspace.dir}/org.jacoco.example.server/classes"/>
        </classfiles>
        <sourcefiles>
            <fileset dir="${workspace.dir}/org.jacoco.example.server/src"/>
        </sourcefiles>
    </group>
    <group name="Client">
        <classfiles>
            <fileset dir="${workspace.dir}/org.jacoco.example.client/classes"/>
        </classfiles>
        <sourcefiles>
            <fileset dir="${workspace.dir}/org.jacoco.example.client/src"/>
        </sourcefiles>
    </group>
    ...
</structure>
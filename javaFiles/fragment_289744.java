<target name="generate_version" depends="compile">
    <loadproperties encoding="iso-8859-1" srcfile="${dir.dest}/MyVersion.class">
        <filterchain>
            <classconstants/>
        </filterchain>
    </loadproperties>
</target>
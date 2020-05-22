<copy todir="${preprocessed.absolute.dir}">
            <fileset dir="${orginal.source.dir}">
                <include name="**/*.aidl" />
            </fileset>
            <fileset dir="${common.absolute.dir}">
                <include name="**/*.aidl" />
            </fileset>
            <fileset dir="${android.absolute.dir}">
                <include name="**/*.aidl" />
            </fileset>
            <fileset dir="${tts.absolute.dir}">
                <include name="**/*.aidl" />
            </fileset>
</copy>
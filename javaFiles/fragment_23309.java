<!-- copy data & images folders' contents to dist folder on build. -->
    <target name="-post-jar" description="Copying Images">
        <property name="images.dir" value="${dist.dir}/images" />
        <property name="data.dir" value="${dist.dir}/data" />

        <copy todir="${images.dir}">
            <fileset dir="./images" />
        </copy>
        <echo level="info" message="Images folder content was copied."/>

        <copy todir="${data.dir}">
            <fileset dir="./data" />
        </copy>
        <echo level="info" message="Data folder content was copied."/>
    </target>
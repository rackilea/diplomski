<condition property="ant.extensions.missing">
    <not>
        <available classname="readproject.ant.FileOlderOrMissingCondition" classpath="${main.jar}" />
    </not>
</condition>

<target name="ant-bootstrapping" depends="init" if="ant.extensions.missing" description="(internal) build the project-internal Ant extensions if needed">
    <antcall target="force-resolve" />
    <javac srcdir="${src}" destdir="${build}" classpathref="build.classpath" includeantruntime="false" includes="**/ant/**/*.java" debug="on"/>
</target>


<!-- need to set up the conditions internally, since the custom types are defined in the project itself -->
<target name="pre-resolve" depends="ant-bootstrapping" description="(internal) set up internal variables to determine if Ivy needs refreshing">
    <typedef onerror="report" name="olderormissing" classname="myproject.ant.FileOlderOrMissingCondition" classpath="${build}" />
    <condition property="ivy.needs.refresh">
        <!-- only fetch ivy deps hourly -->
        <olderormissing file="${ivy.build.record}" threshold="3600" />
    </condition>
</target>

<target name="resolve" description="retrieve dependencies with ivy" if="ivy.needs.refresh" depends="pre-resolve">
    <antcall target="force-resolve" />
</target>

<target name="force-resolve" description="Force retrieval of Ivy dependencies">
    <ivy:retrieve symlink="true" sync="false" pattern="${jars.dir}/[conf]/[artifact].[ext]" keep="true" log="download-only" />
    <ivy:report todir="${ivy.reports}" />
    <touch file="${ivy.build.record}" />
</target>
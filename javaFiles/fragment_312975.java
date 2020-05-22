<project name="ProjectName" basedir=".">
    <property name="home.dir" value="${basedir}"/>
    <property name="build.dir" value="${home.dir}/build"/>
    <property name="src.dir" value="${home.dir}/src"/>
    <property name="report.dir" value="${home.dir}/report" />
    <property name="lib.dir" value="H:/Selenium/jar_collection"/>
    <!-- setClassPath -->
    <target name="setClassPath">
        <path id="classpath_jars">
            <pathelement path="${basedir}/" />
            <fileset dir="${lib.dir}" includes="*.jar" />
        </path>
        <pathconvert pathsep=":" property="test.classpath" refid="classpath_jars" />
    </target>
    <!-- build -->
    <target name="build">
        <mkdir dir="${build.dir}"/>
        <tstamp>
            <format property="timestamp" pattern="dd-MM-yyyy_(HH-mm-ss)"/>
        </tstamp>
        <property name="build.log.dir" location="${basedir}/buildlogs"/>
        <mkdir dir="${build.log.dir}"/>
        <property name="build.log.filename" value="build_${timestamp}.log"/>
        <record name="${build.log.dir}/${build.log.filename}" loglevel="verbose" append="false"/>
        <echo message="build logged to ${build.log.filename}"/>
    </target>
    <!-- Clean -->
    <target name="clean">
        <echo message="deleting existing build directory"/>
        <delete dir="${build.dir}"/>
    </target>
    <!-- Compile -->
    <target name="compile" depends="clean,build,setClassPath">
        <echo message="classpath:${test.classpath}"/>
        <echo message="compiling.........."/>
        <javac destdir="${build.dir}" srcdir="${src.dir}" classpath="${test.classpath}"/>
    </target>
    <!-- Execute -->    
    <target name="exec" depends="compile">
        <delete dir="${report.dir}" />
        <mkdir dir="${report.dir}" />
            <mkdir dir="${report.dir}/xml" />
        <junit printsummary="yes" haltonfailure="no">
            <classpath>
                <pathelement location="${build.dir}" />
                <fileset dir="${lib.dir}">
                    <include name="${src.dir}/TestCases/OpenCart.class" />
                </fileset>
            </classpath>
            <test name="com.selftechy.seltests.SeleniumTest" haltonfailure="no" todir="${report.dir}/xml" outfile="TEST-result">
                <formatter type="xml" />
            </test>
        </junit>
        <junitreport todir="${report.dir}">
            <fileset dir="${report.dir}/xml">
                <include name="TEST*.xml" />
            </fileset>
            <report format="frames" todir="${report.dir}/html" />
        </junitreport>
    </target>
    </project>
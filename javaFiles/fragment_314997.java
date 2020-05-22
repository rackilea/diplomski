<target name="-post-jar">

<property name="store.jar.name" value="${application.title}${application.desc}-portable"/>
<property name="store.dir" value="dist-portable"/>
<property name="store.jar" value="${store.dir}/${store.jar.name}.jar"/>

<echo message="Packaging ${application.title}${application.desc} into a single JAR at ${store.jar}"/>

    <delete dir="${store.dir}"/>
    <mkdir dir="${store.dir}"/>


    <jar destfile="${store.dir}/temp_final.jar" filesetmanifest="skip">
        <zipgroupfileset dir="dist" includes="*.jar"/>
        <zipgroupfileset dir="lib" includes="*.jar"/>
        <fileset dir="lib" includes="*.so"/>

        <manifest>
            <attribute name="Main-Class" value="${main.class}"/>
        </manifest>
    </jar>

    <zip destfile="${store.jar}">
        <zipfileset src="${store.dir}/temp_final.jar"
        excludes="META-INF/*.SF, META-INF/*.DSA, META-INF/*.RSA"/>
    </zip>

<delete file="${store.dir}/temp_final.jar"/>

</target>
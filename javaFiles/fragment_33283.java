<target name="war" depends="jar">
    <war destfile="${deploy}/file.war" webxml="${web-inf}/web.xml">
        <classes dir="${web-inf.classes}">
          <include name="**/Scriptlet.class"/>
        </classes>
        <fileset dir="${WebRoot}">
            <include name="**/*.vm" />
            <include name="**/*.js" />
            <include name="**/*.jsp" />
            <include name="**/*.html" />
            <include name="**/*.css" />
            <include name="**/*.gif" />
            <include name="**/*.jpg" />
            <include name="**/*.png" />
            <include name="**/*.tld" />
            <include name="**/applicationContext*.xml" />
            <include name="**/jpivot/**" />
            <include name="**/wcf/**" />
            <include name="**/platform/**" />
            <include name="**/Reports/**" />
        </fileset>
        <lib dir="${web-inf.lib}" />
    </war>
</target>
<project name="demo" default="notify">

    <target name="install-jars" description="Install ANT optional jars">
        <mkdir dir="${user.home}/.ant/lib"/>
        <get dest="${user.home}/.ant/lib/mail.jar"       src="http://search.maven.org/remotecontent?filepath=javax/mail/mail/1.4.4/mail-1.4.4.jar"/>
        <get dest="${user.home}/.ant/lib/activation.jar" src="http://search.maven.org/remotecontent?filepath=javax/activation/activation/1.1/activation-1.1.jar"/>
    </target>

    <target name="notify" description="notify team">
        <mail subject="latest deployment">
            <from address="me@gmail.com" />
            <to address="jimmy@yahoo.com" />
            <message>A new build has been pushed out to prod</message>
        </mail>
    </target>

</project>
<exec executable="cf.cmd" output="${java.io.tmpdir}/cmd_out.txt" failonerror="true" vmlauncher="false">
    <arg value="curl" />
    <arg value="POST" />
    <arg value="http://www.google.com/v2/routes" />
    <arg value="--body" />
    <arg value="&apos;{&quot;host&quot;:&quot;${old.app.name}&quot;,&quot;domain_guid&quot;:&quot;${domain.guid}&quot;,&quot;space_guid&quot;:&quot;${space.guid}&quot;}&apos;" />
</exec>
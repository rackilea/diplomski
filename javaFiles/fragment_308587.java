<!-- give the service user full access to install dir -->
<exec executable="cacls" failonerror="true" osfamily="winnt" output="NUL">
  <arg line="&quot;${dir.install}&quot; /e /p ${service.username}:f" />
</exec>

<!-- remove the Users group access from the install dir -->
<exec executable="cacls" failonerror="true" osfamily="winnt" output="NUL">
  <arg line="&quot;${dir.install}&quot; /e /t /r Users" />
</exec>

<!-- give the service user the right to log on as a service,
     remove right to logon through the UI -->
<exec executable="${dir.installer}/install/ntrights">
  <arg line="-u ${service.username} +r SeServiceLogonRight" />
</exec>
<exec executable="${dir.installer}/install/ntrights">
  <arg line="-u ${service.username} +r SeDenyInteractiveLogonRight" />
</exec>
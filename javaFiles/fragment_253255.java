<Host name="somesrv.domain.local" appBase="somesrv"
        unpackWARs="true" autoDeploy="true">
    ...
    <Realm className="org.apache.catalina.realm.JNDIRealm"
           connectionURL="ldap://pdc.domain.local:389"
           alternateURL="ldap://bdc.domain.local:389"
           connectionName="CN=tomcat,OU=Services,DC=domain,DC=local"
           connectionPassword="qwerty"
           referrals="follow"
           userBase="OU=someou,DC=domain,DC=local"
           userSearch="(sAMAccountName={0})"
           userSubtree="true"
           roleBase="OU=Security Groups,DC=domain,DC=local"
           roleName="name"
           roleSubtree="true"
           roleSearch="(member={0})" />
</Host>
<Context
    path="/manager"
    docBase="${catalina.home}/server/webapps"
    privileged="true">
    <Valve className="org.apache.catalina.valves.RemoteAddrValve"
      allow="127\.0\.0\.1"
    />
</Context>
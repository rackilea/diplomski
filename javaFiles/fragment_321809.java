<http:conduit name="{http://apache.org/hello_world}HelloWorld.http-conduit">
<http:tlsClientParameters>
  <sec:trustManagers>
    <sec:keyStore type="JKS" password="password"
                  file="my/file/dir/Truststore.jks"/>
  </sec:trustManagers>
</http:tlsClientParameters>
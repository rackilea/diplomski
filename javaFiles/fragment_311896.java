<datasource jndi-name="java:jboss/datasources/MyDatabaseName" pool-name="MyPoolName" enabled="true" use-java-context="true">
  <connection-url>jdbc:jtds:sqlserver://MYHOSTNAME:1433/MyDatabaseName;domain=ABC</connection-url>
  <driver>jtds</driver>
  <pool>
    <min-pool-size>1</min-pool-size>
    <max-pool-size>10</max-pool-size>
    <prefill>true</prefill>
  </pool>
  <security>
    <user-name>dbuser</user-name>
    <password>dbpass</password>
  </security>
</datasource>
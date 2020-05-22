<domain log-root="${com.sun.aas.instanceRoot}/logs" application-root="${com.sun.aas.instanceRoot}/applications" version="12">
  <resources>
    ...
    <jdbc-connection-pool validation-table-name="SYSIBM.SYSDUMMY1" driver-classname="" datasource-classname="org.apache.derby.jdbc.ClientDataSource40" res-type="javax.sql.DataSource" description="" name="GalleriaPool" is-connection-validation-required="true" fail-all-connections="true" ping="true">
      <property name="User" value="APP"></property>
      <property name="DatabaseName" value="GALLERIA"></property>
      <property name="RetrieveMessageText" value="true"></property>
      <property name="CreateDatabase" value="true"></property>
      <property name="Password" value="APP"></property>
      <property name="ServerName" value="localhost"></property>
      <property name="Ssl" value="off"></property>
      <property name="SecurityMechanism" value="4"></property>
      <property name="TraceFileAppend" value="false"></property>
      <property name="TraceLevel" value="-1"></property>
      <property name="PortNumber" value="1527"></property>
      <property name="LoginTimeout" value="0"></property>
    </jdbc-connection-pool>
    <jdbc-resource pool-name="GalleriaPool" description="" jndi-name="jdbc/galleriaDS"></jdbc-resource>
  </resources>
  <servers>
    <server name="server" config-ref="server-config">
    ...
      <resource-ref ref="jdbc/galleriaDS"></resource-ref>
    </server>
  </servers>
  ...
  <configs>
    <config name="server-config">
    ...
      <security-service>
        <auth-realm name="GalleriaRealm" classname="com.sun.enterprise.security.auth.realm.jdbc.JDBCRealm">
          <property name="jaas-context" value="jdbcRealm"></property>
          <property name="encoding" value="Hex"></property>
          <property name="password-column" value="PASSWORD"></property>
          <property name="datasource-jndi" value="jdbc/galleriaDS"></property>
          <property name="group-table" value="USERS_GROUPS"></property>
          <property name="charset" value="UTF-8"></property>
          <property name="user-table" value="USERS"></property>
          <property name="group-name-column" value="GROUPID"></property>
          <property name="digest-algorithm" value="SHA-512"></property>
          <property name="user-name-column" value="USERID"></property>
        </auth-realm>
        ...
      </security-service>
    </config>
    ...
  </configs>
  ...
</domain>
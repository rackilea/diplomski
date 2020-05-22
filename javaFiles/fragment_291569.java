<datasources>
    <datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true">
        <connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1</connection-url>
        <driver>h2</driver>
        <security>
            <user-name>sa</user-name>
            <password>sa</password>
        </security>
    </datasource>
    <xa-datasource jta="true" jndi-name="java:jboss/datasources/MYDB_ONE" pool-name="MYDB_ONE" enabled="true" use-java-context="true" use-ccm="true">
        <xa-datasource-property name="ServerName">
            localhost
        </xa-datasource-property>
        <xa-datasource-property name="DatabaseName">
            MYDB_ONE
        </xa-datasource-property>
        <xa-datasource-property name="SelectMethod">
            cursor
        </xa-datasource-property>
        <xa-datasource-class>com.microsoft.sqlserver.jdbc.SQLServerXADataSource</xa-datasource-class>
        <driver>sqljdbc</driver>
        <xa-pool>
            <is-same-rm-override>false</is-same-rm-override>
        </xa-pool>
        <security>
            <user-name>some_user</user-name>
            <password>some_password</password>
        </security>
        <validation>
            <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mssql.MSSQLValidConnectionChecker"/>
        </validation>
    </xa-datasource>
    <xa-datasource jta="true" jndi-name="java:jboss/datasources/MYDB_TWO" pool-name="MYDB_TWO" enabled="true" use-java-context="true" use-ccm="true">
        <xa-datasource-property name="ServerName">
            localhost
        </xa-datasource-property>
        <xa-datasource-property name="DatabaseName">
            MYDB_TWO
        </xa-datasource-property>
        <xa-datasource-property name="SelectMethod">
            cursor
        </xa-datasource-property>
        <xa-datasource-class>com.microsoft.sqlserver.jdbc.SQLServerXADataSource</xa-datasource-class>
        <driver>sqljdbc</driver>
        <xa-pool>
            <is-same-rm-override>false</is-same-rm-override>
        </xa-pool>
        <security>
            <user-name>some_user</user-name>
            <password>some_password</password>
        </security>
        <validation>
            <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mssql.MSSQLValidConnectionChecker"/>
        </validation>
    </xa-datasource>
    <drivers>
        <driver name="h2" module="com.h2database.h2">
            <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
        </driver>
        <driver name="sqljdbc" module="com.microsoft.sqlserver.jdbc">
            <driver-class>com.microsoft.sqlserver.jdbc.SQLServerDriver</driver-class>
        </driver>
        <driver name="postgresql" module="org.postgresql">
            <xa-datasource-class>org.postgresql.xa.PGXADataSource</xa-datasource-class>
        </driver>
    </drivers>
</datasources>
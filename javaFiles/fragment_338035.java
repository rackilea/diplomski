<Realm className="org.apache.catalina.realm.JDBCRealm"
       driverName="org.gjt.mm.mysql.Driver"
       connectionURL="jdbc:mysql://localhost/authority?user=dbuser&amp;
       password=dbpass"
       userTable="users" userNameCol="user_name" userCredCol="user_pass"
       userRoleTable="user_roles" roleNameCol="role_name"/>
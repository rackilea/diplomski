new QueryRunner().insert(connection, "INSERT INTO security\n"
                    + "(user_name,\n"
                    + "domain,\n"
                    + "security_permissions,\n"
                    + "audit_user)\n"
                    + "VALUES\n"
                    + "(?,?,?,?)ON DUPLICATE KEY UPDATE security_permissions= values(security_permissions),audit_user = values(audit_user), audit_date=CURRENT_TIMESTAMP;", resultHandler,
                    securityTableModelRow.getUser_name(),
                    securityTableModelRow.getDomain(),
                    securityTableModelRow.getSecurity_permissions(),
                    Main.security.getCurrentLoggedInUser());
sessionFactory.getCurrentSession().doWork(new Work() {
                public void execute(Connection con) throws SQLException {
                    OracleCallableStatement callableStatement = null;
                    try {
                        callableStatement = (OracleCallableStatement) con
                                .prepareCall("begin PREQUEST.ChangeRequest(?,?,?,?,?); end;");
                        callableStatement.setInt(1, request_id);
                        callableStatement.setInt(2, method_id);

                        callableStatement.setString(5, sessionId);
                        callableStatement.setPlsqlIndexTable(3, field_ids,
                                field_ids.length, field_ids.length,
                                OracleTypes.NUMBER, 0);
                        callableStatement.setPlsqlIndexTable(4, fieldValues,
                                field_ids.length, field_ids.length,
                                OracleTypes.VARCHAR, 0);
                        callableStatement.execute();

                    } finally {
                        if (callableStatement != null) {
                            callableStatement.close();
                        }
                    }
                }
            });
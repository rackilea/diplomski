String query = "BEGIN INSERT INTO team (name) values (?) returning id into ?; END;";
CallableStatement cs = conn.prepareCall(query);
cs.setString(1, "cougars");
cs.registerOutParameter(2, OracleTypes.NUMBER);
cs.execute();
System.out.println(cs.getInt(2));
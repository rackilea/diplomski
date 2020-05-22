CallableStatement cs = conn.prepareCall("{call demo.run_demo(?,?)}");
cs.setString(1, "update demo.users set locale=''english'' where user_id = 2");
cs.registerOutParameter(2, Types.INTEGER);

cs.execute();

System.out.println("out="+cs.getInt(2));
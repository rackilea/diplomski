CallableStatement cst = conn.prepareCall("{call OMV_CREAR_INTERACCION(?,?,?,?,?,?,?,?)}");          
cst.setInt(1, Integer.parseInt(objSite));
cst.setString(2, titulo);
cst.setString(3, "CRM");
cst.setString(4, "");
cst.setString(5, razon1);
cst.setString(6, razon2);
cst.setString(7, razon3);
cst.registerOutParameter(8, Types.VARCHAR);//out parameter for p_resultado     
cst.execute();

//to get out parameter
String str = cst.getString(8);
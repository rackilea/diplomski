try{
Map rtn = connection.getTypeMap();
            rtn.put("NEUTRINO_META.PROCESSEXCELFILEARGS", Class.forName("OracleObjects.ProcessExcelFileArgs"));
            String call = "{ ? = call NEUTRINO_META.PKG_EXCEL.PROCESS_FILE_INTERNAL(?, ?) }";
                          cstmt = (OracleCallableStatement)connection.prepareCall(call);
                          cstmt.setQueryTimeout(1800);
                          cstmt.registerOutParameter(1, OracleTypes.STRUCT, "NEUTRINO_META.PROCESSEXCELFILEARGS");
                          cstmt.setString(2, filename);
                          cstmt.setDouble(3, eventType);                          
                          cstmt.execute();

                          ProcessExcelFileArgs args = (ProcessExcelFileArgs)cstmt.getObject(1, rtn);

        }
        catch (SQLException e){
            WriteEventToDb(e.getMessage());
        }        
        finally{
            if (cstmt != null){
                cstmt.close();
            }
        }
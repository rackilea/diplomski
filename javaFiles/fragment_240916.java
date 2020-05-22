ResultSet rs=null;
                String sql_query="select * from exception_main;select * from m_roles"
                String query1=sql_query.toUpperCase();
                            String[] results=query1.split(";");
        CSVWriter writer = new CSVWriter(new FileWriter(csv_file_path + csv_file_name), ',',CSVWriter.NO_QUOTE_CHARACTER);
                    for(int i=0;i<results.length;i++)
                        {
                            if(results[i].startsWith("SELECT"))
                            {
                                System.out.println("Inside select"+ results[i]);
                            ps = conn1.prepareStatement(results[i].toString());
                            rs = ps.executeQuery();




        ...
                       //writing to csv file

                        System.out.println("Count..." + rs.getRow());
                        writer.writeAll(rs, true);
                        System.out.println("Count...2::::" + rs.getRow());
                                             while(rs.next()){

                                rs.deleteRow();

                              }
                         System.out.println("Count...3:::::::" + rs1.getRow());
    }
    }
    writer.close();
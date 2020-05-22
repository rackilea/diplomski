for(int i=0; i<=sheeth.getLastRowNum(); i++){
                row = sheeth.getRow(i);

                int id  = (int) row.getCell(0).getNumericCellValue();
                if(id >= 0) {
                    String nama     = row.getCell(1).getStringCellValue();
                    String rm       = row.getCell(2).getStringCellValue();
                    String nama_ro  = row.getCell(3).getStringCellValue();
                    String no_pks   = row.getCell(4).getStringCellValue();
                    String ket      = row.getCell(5).getStringCellValue();
                    String lob      = row.getCell(6).getStringCellValue();
                    String sql = "INSERT INTO testdatapks VALUES('"+id+"','"+nama+"','"+rm+"','"+nama_ro+"','"+no_pks+"','"+ket+"','"+lob+"')";
                    pstm = (PreparedStatement) con.prepareStatement(sql);
                    pstm.execute();
                    System.out.println("Import rows "+i);
                }
            }
//              parameter
                    String para = txt1.getText();

                    //load report location
                    FileInputStream fis = new FileInputStream("\\src\\test\\report1.jrxml");
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);

                    //set parameters
                    Map map = new HashMap();
                    map.put("testid", para);

                    //compile report
                    JasperReport jasperReport = (JasperReport) JasperCompileManager.compileReport(bufferedInputStream);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);


                    //view report to UI
                        JasperViewer.viewReport(jasperPrint, false);
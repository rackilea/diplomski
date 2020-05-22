drb.addUseFullPageWidth(true);

                DynamicReport dr = drb.build();

JRDataSource ds = new JRBeanCollectionDataSource(lista);

                JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), ds );

                byte[] b = JasperExportManager.exportReportToPdf(jp);
                response.getOutputStream().write(b);

                response.flushBuffer();
                setPath(null);
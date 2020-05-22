StreamResource.StreamSource source = new StreamResource.StreamSource() {

                public InputStream getStream() {
                    byte[] b = null;
                    try {
                        b = JasperRunManager.runReportToPdf(getClass().getClassLoader().getResourceAsStream("reports/report3.jasper"), map, con);
                    } catch (JRException ex) {
                       ex.printStackTrace();
                    }

                    return new ByteArrayInputStream(b);
                }
            };

            StreamResource resource = new StreamResource(source, "report3.pdf", getApplication());
            resource.setMIMEType("application/pdf");

            getApplication().getMainWindow().open(resource, "_new");
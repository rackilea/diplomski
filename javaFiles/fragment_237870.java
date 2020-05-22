Map parameters = new HashMap();
String name = Report.person.getName();
parameters.put("name", name);

jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(
                    getMyData()));
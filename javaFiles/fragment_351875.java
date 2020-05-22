JasperReport jasperReport = JasperCompileManager.compileReport("path/filename.jrxml");

Map<String, Object> parameters = new HashMap<String, Object>();
parameters.put("parameter_name", value); //only if you want to pass any parameters

JRDataSource dataSource = new JREmptyDataSource(); //your db connection

JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
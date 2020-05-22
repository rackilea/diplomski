JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
Map parameters = new HashMap();
parameters.put("ParameterName", "Value Wanna Pass");
parameters.put("Other Parameter", Data source Name For Filling the table);

        JasperReport report = (JasperReport)JRLoader.loadObject("Path for the Jasper");
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
for(int i=0; i<pojoList.size(); i++){
        jrDataSource = new JRBeanCollectionDataSource(pojoList.get(i));
        parameterMap.put("dataSource", pojoList.get(i));
        jasperPrint = JasperFillManager.fillReport(report, parameterMap, jrDataSource);
        jasperPrints.add(jasperPrint);
    }
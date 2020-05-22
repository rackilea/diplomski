Map<String,Object> params = new HashMap<String,Object>();
params.put("yourBean", yourBean);

JasperPrint reportPrint = JasperFillManager.fillReport(
        this.getClass().getClassLoader().getResourceAsStream("/report.jasper"),
                params, new JREmptyDataSource());
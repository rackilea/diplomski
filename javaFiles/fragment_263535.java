JRDataSource dataSource = ...;

Map parameters = new HashMap();
parameters.put("id", 42);

JasperReport report = (JasperReport) 
        JRLoader.loadObject("c:/reports/report.jasper");

JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, dataSource);

JFrame frame = new JFrame("Report");
frame.getContentPane().add(new JRViewer(jasperPrint));
frame.pack();
frame.setVisible(true);
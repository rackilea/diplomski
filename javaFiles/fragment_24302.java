public void PrepareReport(ResultSet rs){
        try{
             String reportName ="/com/mmts/reports/challan.jasper";
             InputStream st = getClass().getResourceAsStream(reportName);
             JasperReport jr= (JasperReport) JRLoader.loadObject(st); 
             Map parameters = new HashMap();
             JasperPrint jp = JasperFillManager.fillReport(jr,parameters,new JRResultSetDataSource(rs));

                JasperExportManager.exportReportToPdf(jp);     
                JasperViewer jv=new JasperViewer(jp,false);
                jv.setTitle("Challan");
                jv.setVisible(true);

                }catch(JRException ex)
                {
                   JOptionPane.showMessageDialog(null, ex);
                }
    }
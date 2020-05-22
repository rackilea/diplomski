private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JasperPrint printer = JasperFillManager.fillReport(getClass().getResourceAsStream("reportRecharge.jasper"), params, new JREmptyDataSource());
            JasperViewer jv = new JasperViewer(printer,false);
            jv.setVisible(true);
        } catch (JRException ex) {
            ex.printStackTrace();
        }
}
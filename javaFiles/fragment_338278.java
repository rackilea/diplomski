private void generateReports(String name, Map param)
{
        try
        {
                String source = "C:/sabonay/jasperreports/" + name + ".jrxml";
                if (new File(source).exists() == false)
                {
                        xputils.showMessage("Please go to setting and Choose report Source");
                        return;
                }

                JasperReport jasperReport = JasperCompileManager.compileReport(source);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, new JRTableModelDataSource(tbProducts.getModel()));

                JasperViewer.viewReport(jasperPrint, false);

        }
        catch (Exception e)
        {
                e.printStackTrace();
                System.out.println("reports Error  " + e.toString());

        }
}
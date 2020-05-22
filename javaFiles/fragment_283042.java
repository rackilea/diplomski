@RequestMapping("/savepdf")
    public void dataEmployeePdf(HttpServletResponse response) {
        try {

            File file = new File("report/reportEmployee.jrxml");
            String absolutePath = file.getAbsolutePath();
            InputStream input = new FileInputStream(new File(absolutePath));
            JasperReport jasperReport = JasperCompileManager.compileReport(input);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null);
            JasperExportManager.exportReportToPdfStream(jasperPrint,response.getOutputStream());
        } catch (JRException ex) {
            ex.getMessage();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
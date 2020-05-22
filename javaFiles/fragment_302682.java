//JasperPrint is already filled

HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
httpServletResponse.setContentType("application/csv; charset=cp1252");
httpServletResponse.setCharacterEncoding("cp1252");
httpServletResponse.addHeader("Content-disposition", "attachment; filename=nameoffile.csv");
httpServletResponse.addHeader("Content-type", "application/csv; charset="+Charset.forName("utf-8").displayName());
ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
JRCsvExporter exporter = new JRCsvExporter();

exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "cp1252");
exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
exporter.setParameter(JRCsvExporterParameter.CHARACTER_ENCODING, "cp1252");
exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, ";");
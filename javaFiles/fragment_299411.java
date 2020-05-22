JRDataSource ds = new JRBeanCollectionDataSource(reportList);

    Resource report = new ClassPathResource("static/jasper/rpt_report.jasper");

    JasperPrint jasperPrint = JasperFillManager.fillReport(report.getInputStream(), Collections.EMPTY_MAP,ds);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    JasperExportManager.exportReportToPdfStream(jasperPrint, baos);
    DataSource aAttachment =  new ByteArrayDataSource(baos.toByteArray(), "application/pdf");

    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);

    helper.setTo("xxxxxx");

    helper.setFrom("xxxxx");
    helper.setSubject("Testing Email");

    String text = "Testing Email";

    helper.setText(text, false);

    helper.addAttachment("report.pdf",aAttachment);

    mailSender.send(message);
ViewSupport viewSupport = ViewSupport.Factory.newInstance();
viewSupport.setOutputFormat(OutputFormatType.INT_XML);
viewSupport.setViewType(ViewType.INT_CHARACTER);
viewSupport.setViewMode(ViewModeType.INT_REPORT_PAGE);

RetrieveData retBOData = RetrieveData.Factory.newInstance();

RetrieveXMLView retXMLView = RetrieveXMLView.Factory.newInstance();
retXMLView.setViewSupport(viewSupport);
retBOData.setRetrieveView(retXMLView);
DocumentInformation boDocInfo = getDocInfo(actions, retBOData);
XMLView bView = (XMLView) boDocInfo.getView();
ByteArrayOutputStream out = new ByteArrayOutputStream(bView.getContentLength());
bView.getContent().save(out);
byte[] reportBytes = out.toByteArray();
String reportInString = new String(reportBytes);
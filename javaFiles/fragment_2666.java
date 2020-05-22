public DynamicReport buildDynamicReport() throws ReportDocumentGenerationException {
  DynamicReportBuilder drb = new DynamicReportBuilder();
  drb.setDetailHeight(detailHeight)     
  .setMargins(properties.getReportMargins().getTopMargin(), properties.getReportMargins().getBottomMargin(), properties.getReportMargins().getLeftMargin(), properties.getReportMargins().getRightMargin())     
  .setDefaultStyles(null, null, null, getSpoolStyle(SpoolRow.PLAIN_ATTRIBUTE))    
  .setPageSizeAndOrientation(new Page(**/*Your document dimensions and orientation*/**)
  .setColumnsPerPage(1);
   for(ReportDocumentInformationPage page: reportInformation.getPaginas()){
            drb.addConcatenatedReport(getPageSubReport(page.getPageNumber()),new ClassicLayoutManager(),"DS"+page.getPageNumber().toString(),DJConstants.DATA_SOURCE_ORIGIN_PARAMETER, DJConstants.DATA_SOURCE_TYPE_JRDATASOURCE,!page.getPageNumber().equals(1));
            params.put("DS"+page.getPageNumber().toString(), getReportJRDataSource(page.getPageNumber())  );
        }
        drb.setUseFullPageWidth(true);
        DynamicReport dr = drb.build();
        return dr;
    }
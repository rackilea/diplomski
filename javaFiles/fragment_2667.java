*private DynamicReport getPageSubReport(int i) throws ReportDocumentGenerationException {
        try{
            DynamicReportBuilder drb = new DynamicReportBuilder();
            drb.setDetailHeight(detailHeight)
            .setReportName("Reporte"+i)
            .setMargins(properties.getReportMargins().getTopMargin(), properties.getReportMargins().getBottomMargin(), properties.getReportMargins().getLeftMargin(), properties.getReportMargins().getRightMargin())
            .setDefaultStyles(null, null, null, getSpoolStyle(SpoolRow.PLAIN_ATTRIBUTE))    
            .setPageSizeAndOrientation(new Page(**/*Your specific Page dimensions and orientation***/)
            .setColumnsPerPage(1);

            AbstractColumn spoolColumn = ColumnBuilder.getNew()     
            .setColumnProperty("value", String.class.getName())     
            .setTitle(null)     
            .setWidth(150)
            .build();       
            spoolColumn.setConditionalStyles(getSpoolConditionalStyle());

            drb.addColumn(spoolColumn);
            drb.setUseFullPageWidth(true);
            drb.addField("attributes", String.class.getName());
            DynamicReport dr = drb.build();
            return dr;
        }catch(ColumnBuilderException cbe){
            cbe.printStackTrace();
            throw new ReportDocumentGenerationException("No se pudo definir correctamente la columna del reporte para la pagina "+i);
        }catch(Exception e){
            e.printStackTrace();
            throw new ReportDocumentGenerationException("No se pudo generar la pagina "+i+" del reporte");
        }
    }*
grid.getField(MerchandiseSellerTargetsDS.FLD_TARGETTYPE).setCellFormatter(new CellFormatter() {         
    @Override
    public String format(Object value, ListGridRecord record, int rowNum, int colNum) {
        short targetTypeMapKey = Short.valueOf((String)value);
        return Messages.targetTypeMap.get(targetTypeMapKey);
    }
    });
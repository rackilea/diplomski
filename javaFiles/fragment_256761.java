movieTitleColumn.setCellValueFactory(cellData -> {
    try {
        return new JavaBeanStringPropertyBuilder()
            .bean(cellData.getValue())
            .name("title")
            .build();
    } catch (Exception e) { throw new RuntimeException(e); }
}
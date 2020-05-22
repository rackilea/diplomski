public ExtractionType getType(ExportProfile profile) {
    switch (profile.getExtractionTypeEnum()) {
        case ExtractionTypeEnum.TYPE1:
            return ConcreteExtractionType1.getInstance();
        case ExtractionTypeEnum.TYPE2:
            return ConcreteExtractionType2.getInstance();
    }
}
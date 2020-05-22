Page<ObjectEntity> entities = objectEntityRepository.findAll(pageable);
Page<ObjectDto> dtoPage = entities.map(new Converter<ObjectEntity, ObjectDto>() {
    @Override
    public ObjectDto convert(ObjectEntity entity) {
        ObjectDto dto = new ObjectDto();
        // Conversion logic

        return dto;
    }
});
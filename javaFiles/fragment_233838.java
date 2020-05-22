private void start() {
    final Mapper mapper = new Mapper();
    Page<Entry> entryPage = entryRepository.findAll(new PageRequest(0, 2));
    Page<EntryDto> entryDtoPage = entryPage.map(
        new Converter<Entry, EntryDto>() {
            public EntryDto convert(Entry source) {
                mapper.getMapperFacade().map(source, EntryDto);
            }
    });
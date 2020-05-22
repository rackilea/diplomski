@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<Void> save(@RequestPart("file") Mono<FilePart> file) {
        log.info("Storing a new file. Recieved by Controller");
        this.storageService.store(file);
        return Mono.empty();
    }
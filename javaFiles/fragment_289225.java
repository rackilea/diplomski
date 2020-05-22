@GetMapping(value = "/videos/p/{id}")
public ResponseEntity<UrlResource> getFullVideo(@PathVariable String id) throws MalformedURLException {
    Optional<Video> optionalVideo = videoRepository.findById(id);

    if (optionalVideo.isPresent()) {
        final String videoPath = optionalVideo.get().getAbsolutePath();
        final UrlResource video = new UrlResource(String.format("file:%s", videoPath));

        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .contentType(MediaTypeFactory.getMediaType(video)
                        .orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body(video);
    }

    return ResponseEntity.noContent().build();
}
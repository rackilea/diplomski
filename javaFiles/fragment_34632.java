public Mono<Artist> getArtistInfo(String id) {
    return webClient.get()
            .uri("/artist")
            .retrieve()
            .bodyToMono(ArtistResponse.class)
            .flatMap(artistResponse -> {
                final Artist artist = new Artist();
                return Flux.fromIterable(artistResponse.getAlbums())
                        .parallel(2)
                        .runOn(Schedulers.parallel())
                        .map(albums -> webClient.get()
                                .uri("artist/albums")
                                .retrieve()
                                .bodyToMono(Covers.class))
                        .doOnNext(coversMono -> coversMono
                            .doOnSuccess(covers -> artist.getAlbums().add(covers)))
                        .thenReturn(artist);
            })
            .doOnSuccess(artist -> webClient.get()
                    .uri("/artist/profile")
                    .retrieve()
                    .bodyToMono(Profiles.class)
                    .doOnSuccess(profiles -> artist.setDescription(profiles.getDescription())));
}
event.setArtistSupplier(
        (b, c) -> new ArtistIterator<R, U, T>(
                e.getArtistName(),
                (a) -> lastfmApi.getArtistInfo(e.getArtistName())
        )
);
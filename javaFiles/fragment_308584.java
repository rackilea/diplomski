/**
     * Change the base of target URI to new base, using root
     * as common path.
     * @param base New base
     * @param root Common root
     * @param target Target to rebase
     * @return Path with new base
     * @throws IOException If fails
     */
    @SuppressWarnings("PMD.DefaultPackage")
    static Path rebase(final Path base, final Path root, final Path target)
        throws IOException {
        final URI uri = target.toUri();
        try {
            return new Path(
                new Path(
                    new URIBuilder(base.toUri())
                        .setHost(uri.getHost())
                        .setPort(uri.getPort())
                        .build()
                ),
                new Path(
                    new URIBuilder(root.toUri())
                        .setHost(uri.getHost())
                        .setPort(uri.getPort())
                        .build()
                        .relativize(uri)
                )
            );
        } catch (final URISyntaxException err) {
            throw new IOException("Failed to rebase", err);
        }
    }
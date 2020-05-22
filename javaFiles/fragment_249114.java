class NumericFilter implements DirectoryStream.Filter<Path> {

    private static final Pattern PATTERN = Pattern.compile("\\d+|\\d+\\..*");

    @Override
    public boolean accept(Path entry) throws IOException {
        return PATTERN.matcher(entry.getFileName().toString()).matches();
    }

}
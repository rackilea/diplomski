//use final keyword to permit access in the filter.
final Date dateRechercheeA = new Date();
final Date dateRechercheeB = new Date();

Path repertoire = Paths.get("[repertoire]");
try (DirectoryStream<Path> stream = Files.newDirectoryStream(repertoire, new DirectoryStream.Filter<Path>() {
    @Override
    public boolean accept(Path entry) throws IOException {
        long entryDateDays = Files.getLastModifiedTime(entry, LinkOption.NOFOLLOW_LINKS).to(TimeUnit.DAYS);
        return !entry.getFileName().endsWith("TAM") //does not take TAM file
                && !entry.getFileName().endsWith("RAM") //does not take RAM file
                && ((dateRechercheeB == null && Math.abs(entryDateDays - TimeUnit.DAYS.toDays(dateRechercheeA.getTime())) <= 1)
                || (dateRechercheeB != null && entryDateDays >= (TimeUnit.DAYS.toDays(dateRechercheeA.getTime()) - 1) && entryDateDays <= (TimeUnit.DAYS.toDays(dateRechercheeA.getTime()) + 1)));
    }
})) {
    Iterator<Path> it = stream.iterator();
    //Iterate good file...

}
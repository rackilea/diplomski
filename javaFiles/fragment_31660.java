final Splitter s = Splitter.on('\t');
Files.lines(myFile.toPath()).map(x -> s.splitToList(x)).forEach(new Consumer<List<String>>() {

    @Override
    public void accept(final List<String> t) {
        //do stuff
    }
});
private class ExtractorThread extends Task<DbExtractor>{
    private ConnectionProperties cp;

    public DbExtractor call() throws Exception {
        dbe = new DbExtractor(cp);
        dbe.extract();
        return dbe;   

    }


    public void setCp(ConnectionProperties cp) {
        this.cp = cp;
    }
}
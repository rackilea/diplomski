// create a new har with given label
public void setHar(String label) {
    server.newHar(label);
}

public void getHar() throws IOException {
    // FIXME : What should be done with the this data?
    Har har = server.getHar();
    if (har == null) return;
    File harFile = new File("C:\\localdev\\bla.har");
    har.writeTo(harFile);
    for (HarEntry entry : har.getLog().getEntries()) {
        // Check for any 4XX and 5XX HTTP status codes
        if ((String.valueOf(entry.getResponse().getStatus()).startsWith("4"))
                || (String.valueOf(entry.getResponse().getStatus()).startsWith("5"))) {
            log.warn(String.format("%s %d %s", entry.getRequest().getUrl(), entry.getResponse().getStatus(),
                    entry.getResponse().getStatusText()));
            //throw new UnsupportedOperationException("Not implemented");
        }
    }
}
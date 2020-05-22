while (fileIterator.hasNext()) {
    FileItemStream fi = fileIterator.next();

    if ("mybody".equals(fi.getFieldName())) {
        BufferedReader br = new BufferedReader(
                 new InputStreamReader(fi.openStream()));
        String fieldValue = null;
        if ((line = br.readLine()) != null) {
            fieldValue = line;
        }
    } else if ("fileToUpload".equals(fi.getFieldName())) {
        (...)
    }
    (...)
}
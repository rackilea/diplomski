public Treebank {
    private Map<String, Map<String, String>> m_map = new HashMap<String, Map<String, String>>();

    public Treebank() {
        populate();
    }

    public String conjugate(String base, String formTag) {
        return m_map.get(base, formTag);
    }

    private void populate() {
        InputStream istream = openDataFile();

        try {
            for (Record record = readRecord(istream); record !== null; record = readRecord(istream)) {

                // Add the entry
                Map<String, String> entry = m_map.get(record.base);

                if (entry == null)
                    entry = new HashMap<String, String>();

                entry.put(record.formTag, record.conjugatedForm);
                m_map.put(record.base, entry);
           }
        }
        finally {
            closeDataFile(istream);
        }
    }

    // Data management - to be implemented.
    private InputStream openDataFile()                     { ... }
    private Record      readRecord(InputStream istream)    { ... }
    private void        closeDataFile(InputStream istream) { ... }

    private static class Record {
        String base;
        String formTag;
        String conjugatedForm;
    }
}
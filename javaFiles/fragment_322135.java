String[] data = new String[]{"report-final.pdf--@19.5625", "references.pdf--@46.25", "multithread.pdf--@166.85546875", "report-final.pdf--@19.5625"};
Set<String> entries = new HashSet<>();
for (String entry : data) {
    if (!entries.add(entry)) {
        System.out.println("Duplicate file entry: " + entry);
    }
}
List<String> xlsFiles = new ArrayList<String>();
for(String i : downloadFiles) {
    if(i.endsWith(".xls")) {
        xlsFiles.add(i);
    }
}
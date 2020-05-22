List<String> list = new ArrayList<>();
List<String> fileList = File.getPageList();

// sort the fileList using File::TotalPages as key extractor for the comperator
fileList.sort(Comparator.comparing(File::TotalPages).reversed());

// use the sorted list for building the result:
for(String e:fileList) {
    list.add(e + " " + File.TotalPages(e) + " visits");     
}
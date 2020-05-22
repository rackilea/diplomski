List<String> result = new ArrayList<>();
String content = FileUtils.readFileToString(file, "UTF-8");
for (String s : content.split(", ")) {
    if (!s.equals(findME)) { // assuming both have string quotes added already
        result.add(s);
    }
}
FileUtils.write(newFile, String.join(", ", result), "UTF-8");
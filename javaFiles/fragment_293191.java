private LocalDate getDateFromPriipsDoc(File file) {
   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
   String fileName = FilenameUtils.getBaseName(file.toString());
   String dateInString = fileName.substring(fileName.lastIndexOf("_") + 1);
   return LocalDate.parse(dateInString, formatter);
}
List<List<String>> sections = new ArrayList<>();
List<String> currentSection = null;

try (BufferedReader br = new BufferedReader(new FileReader(file))) {
  String line;
  while ((line = br.readLine()) != null) {
    if(line.startsWith("rule ")) {
      if (currentSection != null) {
        // we are finished with the previous section!
        sections.add(currentSection);
      }
      currentSection = new ArrayList<>();
      currentSection.add(line);
    } else {
      if(! line.trim().isEmpty()) {
        // any non-empty line goes into the current section
        currentSection.add(line);          
      }
    }
 }
} // end of try/while ... I am too lazy to count my braces ;-)
if (currentSelection != null) {
  // make sure to add the final section, too!
  sections.add(currentSelection); 
}
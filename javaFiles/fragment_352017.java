ReverseTemplateEngine rte = new ReverseTemplateEngine(
   "*** ID: $ ***",
   "- type: $",
   "- time-stamp: $",
   "* Device: XKK-$");

List<String> result = rte.parse(new BufferedReader(
     new FileReader("yourfile.txt")));
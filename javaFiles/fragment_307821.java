// Create the mapper
ObjectMapper mapper = new ObjectMapper();

// Setup a pretty printer with an indenter (indenter has 4 spaces in this case)
DefaultPrettyPrinter.Indenter indenter = 
        new DefaultIndenter("    ", DefaultIndenter.SYS_LF);
DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
printer.indentObjectsWith(indenter);
printer.indentArraysWith(indenter);

// Some object to serialize
Map<String, Object> value = new HashMap<>();
value.put("foo", Arrays.asList("a", "b", "c"));

// Serialize it using the custom printer
String json = mapper.writer(printer).writeValueAsString(value);

// Print it
System.out.println(json);
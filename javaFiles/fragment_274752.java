String regex ="\\s*public\s+static\s+[\w\.\<\>,\s]+\s+getFieldsConfig\\(.*?\\)\\s*\\{.*?\\}(?=\\s*(public|private|protected|static))";

String regex2 = "\\s*public\s+static\s+[\w\.\<\>,\s]+\s+getFieldsConfig\\(.*?\\)\\s*\\{.*?\\}(?=(\\s*}\\s*$))";

regex = "(" + regex +")|("+ regex2 + "){1}?";

Pattern pattern = Pattern.compile(regex, Pattern.DOTALL)
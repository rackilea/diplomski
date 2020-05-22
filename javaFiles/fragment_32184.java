StringBuilder searchString = new StringBuilder();

builder1.append("line one");
builder1.append(System.lineSeparator());
builder1.append("line two");

System.out.println(lineInFile.toString().contains(searchString));
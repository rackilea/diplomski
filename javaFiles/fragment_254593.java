FileResource resource = new FileResource("data/someText.txt");
StringBuilder message = new StringBuilder();

for(String line: resource.lines()) { 
  message.append(line + " ");
}

System.out.println(message);
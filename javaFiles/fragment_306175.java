Arrays.asList(resources).stream()
                        .forEach(resource ->{ 
                                  Pattern dirPattern = Pattern.compile(".*?\\[(.*/(.*?))/\\]$");
                                  if (resource.toString().matches(".*?\\[.*?\\]$")) {
                                      Matcher matcher = dirPattern.matcher(resource.toString());
                                     if (matcher.find()) {
                                        String dir = matcher.group(1);
                                        readFile(dir);
                                      }
                                  }
                             });


public void readFile(String dir)
{

   ClassPathResource classPathResource = new ClassPathResource(dir+ "/conf.txt");
    try (BufferedReader fileReader = new BufferedReader(
            new InputStreamReader(classPathResource2.getInputStream()))) {
        fileReader.lines().forEach(data -> System.out.println(data));
     }catch (IOException e) {
        e.printStackTrace();
    }
}
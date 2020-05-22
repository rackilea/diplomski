FileInputStream stream = new FileInputStream("nums.txt");
BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
String line;

while((line = reader.readLine()) != null) {
    StringTokenizer tokenizer = new StringTokenizer(line, " ");
    int tokens = tokenizer.countTokens();
    float average = 0;

    while(tokenizer.hasMoreTokens()) {
        String token = tokenizer.nextToken();
        int value = Integer.valueOf(token);
        average += value;
    }

    System.out.println(average / tokens);
}
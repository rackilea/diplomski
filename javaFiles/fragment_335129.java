public static void main(String[] args) throws IOException {
  try (Scanner input = new Scanner(new File("input.txt"))) {
     List<String> inputText = new ArrayList();
     while (input.hasNextLine()) {
         inputText.add(input.nextLine());             
     }
     Arrays.sort(inputText);
     for (String str : inputText) {
          System.out.println(str);
     }            
 }
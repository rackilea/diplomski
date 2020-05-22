String text = new Scanner( new File("test.txt") ).useDelimiter("\\A").next();
String key = "jumps";
if (Arrays.asList(text.split("[\\s]")).indexOf(key) != -1)
    System.out.println("Match");
else
    System.out.println("No match");
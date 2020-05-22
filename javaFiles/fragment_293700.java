Scanner scanner = new Scanner(new File("C:/Users/msi/Documents/number.txt"));

Hashtable<String, String> numbers = new Hashtable<String, String>();

while(scanner.hasNext()) 
{
    String[] values = scanner.next().split(" ");
    numbers.put(values[0], values[1]);
    System.out.println(numbers);
}
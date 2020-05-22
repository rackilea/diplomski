Scanner scanner = new Scanner(System.in);
int[] values = new int[2];
String[] arguments = scanner.nextLine().split(" ");
for(int i = 0; i < arguments.length && i < values.length; i++){
    values[i] = Integer.parseInt(arguments[i]);
}
scanner.close();
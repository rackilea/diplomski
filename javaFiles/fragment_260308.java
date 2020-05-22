System.out.println("NAME  TYPE  LINE# ");
String[][] data = {{"a", "prod", "1"}, {"b", "prod", "2"}};        

for (int i = 0; i < data.length; i++) {
    System.out.println(String.format("%-5s %-5s %-5s", data[i][0], data[i][1], data[i][2]));
}
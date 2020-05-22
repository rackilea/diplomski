String str = "182, 0, 192, 15";
String[] values = str.split(", ");
if (values.length >= 4) {
    int x = Integer.parseInt(values[0].trim());
    int y = Integer.parseInt(values[1].trim());
    int width = Integer.parseInt(values[2].trim());
    int height = Integer.parseInt(values[3].trim());
    System.out.printf("x = %d, y = %d, width = %d, height = %d\n", x,
            y, width, height);
}
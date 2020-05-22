String str = "12,13,14,15";
String[] strArray = str.split(",");

int[] intArray = new int[strArray.length];

for (int i = 0; i < strArray.length; i++) {
    try {
        intArray[i] = Integer.parseInt(strArray[i]);
    } catch (NumberFormatException e) {
        // Handle the exception properly as noted by Jon
        e.printStackTrace();
    }
}
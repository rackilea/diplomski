String timestamp = "343:45:37";
String[] components = timestamp.split(":");
boolean validTimestamp = false;
int h = -1, m = -1, s = -1;
try {
    if (validTimestamp = components[1].length() == 2 && components[2].length() == 2) {
        h = Integer.valueOf(components[0]);
        m = Integer.valueOf(components[1]);
        s = Integer.valueOf(components[2]);
    }
} catch (Exception e) {
    e.printStackTrace();
}
validTimestamp = validTimestamp && h >= 0 && m >= 0 && m < 60 && s >= 0 && s < 60;
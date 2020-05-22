String fullName = "John Erich Daws Black";
int idx = fullName.lastIndexOf(' ');
if (idx == -1)
    throw new IllegalArgumentException("Only a single name: " + fullName);
String firstName = fullName.substring(0, idx);
String lastName  = fullName.substring(idx + 1);
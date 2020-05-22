String password = ...
String username = ...
boolean match = false;

try (BufferedReader br = new BufferedReader(new FileReader(file path))) {
     String line;
     while (!match && ((line = br.readLine()) != null)) {
          String[] s = line.split(":");
          if (username.equals(s[0]) && username.equals(s[1])) {
              match = true;
          }
     }
}

if (match) {
    // handle successful login
} else {
    // error message
}
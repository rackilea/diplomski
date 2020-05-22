// Construct the query string with the proper username and password
URL url = new URL("http://www.yoursite.com/verify.php?username=happy&password=pants");
try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
    StringBuilder sb = new StringBuilder();
    for (String s; (s = in.readLine()) != null;)
        sb.append(s);
    switch (sb.toString().trim()) {
    case "welcome": 
        JOptionPane.showMessageDialog(null, "Welcome!");
        // Proceed to game
        break;
    case "shut up and pay me":
        JOptionPane.showMessageDialog(null, "You owe me money first!");
        break;
    case "no such user":
        JOptionPane.showMessageDialog(null, "Go away!");
        // Recursively delete all their files...
        break;
    }
}
Map<String, Media> instances = new HashMap<>();
// snip...
String moviet = JOptionPane.showInputDialog("Title:");
int movieID = Integer.parseInt(JOptionPane.showInputDialog("ID:"));
Movie moviett = new Movie(moviet, movieID);
instances.put("some user-provided string", moviett);
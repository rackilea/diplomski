if (links != null) {
  Iterator lit = links.iterator();
  while (lit.hasNext()) {
    Link l = lit.next();
    String lname = l.getApplicationName();
    if (lname.equalsIgnoreCase(appname)) {
      userid = (String) l.getAttribute("User Name");
      List organizations = l.getAttribute("Organization");
      for (Object organization : organizations) {
        // Output file
        out.write(identityName + "," + userid + "," + workforceid + "," + organization);
        out.newLine();
        out.flush();
      }
    }
  }
}
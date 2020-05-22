URLConnection con = servletURL.openConnection();
BufferedInputStream bif = new BufferedInputStream(con.getInputStream());
ObjectInputStream input = new ObjectInputStream(bif);
int avail = bif.available();

System.out.println("Response content size = " + avail);
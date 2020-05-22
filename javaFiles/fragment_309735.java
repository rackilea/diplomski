PrintWriter out = null;
try {
    File f = new File("c:/users/dell/desktop/ja/MyLOgs.txt");
    out = new PrintWriter(new FileWriter(f,true));
    out.println("the name of the  user is "+name+"\n");
    out.println("the email of the user is "+ email+"\n");
} finally {
    out.close();
}
try {
PreparedStatment stmt = null;
stmt = con.prepareStatement("SOME AWESOME SQL");
//lots of lines of code that masks the problem
stmt = con.prepareStatment("DIFFERENT SQL"); //You just leaked "SOME AWESOME SQL"!!!
//lots more code
} finally {
stmt.close() //looks like everything is ok, but only the second one actually got closed
}
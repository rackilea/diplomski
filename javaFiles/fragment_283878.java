PrintWriter pw = new PrintWriter("my.log");

// will actually write to the OS, 5 times. (1000 * 40 / 8192)
for(int i = 0; i < 1000; i++) {
   pw.printf("%39d%n", i); // a 40 character number.
}

pw.flush();
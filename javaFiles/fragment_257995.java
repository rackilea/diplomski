String usage =
  ".Dd \\[year]\n" +
  ".Dt test 1\n" +
  ".Os\n" +
  ".Sh test\n";
...
OutputStream out = groff.getOutputStream();
out.write(usage.getBytes());
out.close();
...
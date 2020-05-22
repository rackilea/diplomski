StringTokenizer st = new StringTokenizer(sourceString, "= ");

while(st.hasMoreTokens()) {

  String key = st.nextToken();
  String valuse = st.nextToken();

  // Do something with the keys and values (i.e. build and execute insert statements.
}
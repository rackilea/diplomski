....
  String st = sc.next();
  int count = st.length();
  count = count-4;
  int count1 = st.length();
  st = st.substring(0,st.lastIndexOf('.')); // get rid of the domain name
  for(char da:st.toCharArray())
      ...
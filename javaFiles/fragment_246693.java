String content="aaaaaaaaaa";
    Pattern pattern = Pattern.compile("a");
    Matcher m = pattern.matcher(content);

    StringBuffer sb = new StringBuffer();
    final int N = 3;
    for (int i = 0; i < N; i++) {
      if (m.find()) {
         m.appendReplacement(sb, "b");
      } else {
         break;
      }
    }
    m.appendTail(sb);
    System.out.println(sb); // bbbaaaaaaa
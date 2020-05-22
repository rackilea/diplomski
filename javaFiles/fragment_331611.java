String s = "25467896743242";
    System.out.println(s.charAt(0));
    StringBuilder sb = new StringBuilder(s);
    s = sb.reverse().toString();
    //int groupCount=4;
    sb = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
        sb.append(s.charAt(i));
        if ((i == 3) || i > 3 && i % 2 == 1) {
            sb.append(',');
        }
    }
    System.out.println(sb);
}
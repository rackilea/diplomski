String s = "123456789";
StringBuilder sb = new StringBuilder();
char[] buff = s.toCharArray();
sb.append(buff , 0, 3).append("foobar");
sb.append(buff,3+3,buff.length -(3+3));
System.out.println(sb.toString());
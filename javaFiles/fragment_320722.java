String msg = "This is a test";
int key = 88;
StringBuilder sb = new StringBuilder();
for(int i=0; i<msg.length(); i++)
    sb.append((char)(msg.charAt(i)^key));
System.out.println(sb.toString());
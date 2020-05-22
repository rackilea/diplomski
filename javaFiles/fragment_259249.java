String s = "FS01,a,b,c,d,1,2,3FS02,x,y,zFS03,some random text,123FS04,1";
String tok[] = s.split("(?<!^)(?=FS\\d{2})");
System.out.println(tok[0]);
System.out.println(tok[1]);
System.out.println(tok[2]);
System.out.println(tok[3]);
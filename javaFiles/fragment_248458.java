String str=(fileChooser.getSelectedFile()).toString();
System.out.println("old:\t"+str);
String aaa= str.replaceAll("\\\\", "/");
System.out.println("new:\t"+aaa);
StringBuilder myName = new StringBuilder(aaa);
myName.setCharAt(2, '\\');
System.out.println("Final String:\t"+myName.toString());
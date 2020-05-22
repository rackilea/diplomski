String path = "D:\\aaa\\bbb\\ccc";
File parent = new File(path).getParentFile();
System.out.println(parent);

String parentStr = new File(path).getParent();
System.out.println(parentStr);
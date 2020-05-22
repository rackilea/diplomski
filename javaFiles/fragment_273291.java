ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("d:/objects.obj"));
System.out.println("writeObject(true)");
out.writeObject(true);
System.out.println("writeBoolean(true)");
out.writeBoolean(true);
System.out.println("writeBoolean(true)");
out.writeBoolean(true);
out.close();//or flush
System.out.println("------------------");

ObjectInputStream in=new ObjectInputStream(new FileInputStream("d:/objects.obj"));
System.out.println("readObject="+in.readObject());
System.out.println("readBoolean="+in.readBoolean());
System.out.println("readObject="+in.readObject());//<- readObject stored by writeBoolean
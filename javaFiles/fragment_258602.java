File f = new File("abc.txt");
OutputStreamWriter out = new OutputStreamWriter(openFileOutput("abc.txt", Context.MODE_WORLD_READABLE));
    BufferedWriter bf = new BufferedWriter(out); 
bf.write("hello world");
bf.close();
System.out.println(f.getAbsolutePath());
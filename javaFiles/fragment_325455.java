try (FileWriter f1 = new FileWriter("file1.txt"))
    {
    f1.write("Hello World. This is a sample text file!");
    }

try (FileReader f2 = new FileReader("file1.txt");)
    {
    int x = f2.read();
    while(x != -1){
        System.out.println((char)x);
        x = f2.read();
    }
    }
String path = null; //track file name
try{
        in1 = new Scanner(new File(path = inPath1));
        in2 = new Scanner(new File(path = inPath2));
} catch (FileNotFoundException e){
        System.err.println("File not found: " + path);//get recent file name
        System.exit(0);
}
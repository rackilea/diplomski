File f = new File("C:\\test\\est.txt");
try
{
    Scanner in = new Scanner(f);
    while (in.hasNext()){
        System.out.println(in.next());
    }
}catch (IOException i){
    e.printStackTrace();
}
public static void main(String[] args){
    String h = null;
    for(int i=7,k=999;i+((h="hello").size())<10;i++){}

    System.out.println("It should be: hello = "+h);
}
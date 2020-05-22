ArrayList<String> listA=new ArrayList<String>();
ArrayList<String> listB=new ArrayList<String>();
ArrayList<String> listC=new ArrayList<String>();

do {
    System.out.println("input a : ");
    a = in.nextLine();
    System.out.println("input b : ");
    b = in.nextLine();
    System.out.println("input c : ");
    c = in.nextLine();

    listA.add(a);
    listB.add(b);
    listC.add(c);

    System.out.println("Again ? (y/n)");
    d = in.nextLine();

} while (d.equals("y"));

for (int i = 0; i < listA.length; i++) 
{
    System.out.println("Output "+(i+1)+" : ");
    System.out.println("a :" + listA.get(i));
    System.out.println("b :" + listB.get(i));
    System.out.println("c :" + listC.get(i));
    System.out.println("");
}
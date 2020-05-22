public class findObject {


public static void replaceLibraryById(Library[] objArray, Library inputlib)
{
    boolean tf = false;
    for(int i=0;i<objArray.length;i++)
    {
        if(inputlib.id==objArray[i].id)
        {
            objArray[i].setName(inputlib.name);
            objArray[i].setAddress(inputlib.address);
            tf=true;
            System.out.println("Output for performing replace on libraryRes1 is : "+tf);
            for(Library l:objArray)
            {
                System.out.println(" " + l.getId()+" " + l.getName()+" " + l.getAddress()+" ");
            }
            break;
        }

    }


    if(tf != true) {
        System.out.println("Output for performing replace on libraryRes1 is : "+tf);
        for(Library l:objArray)
        {
            System.out.println(" " + l.getId()+" " + l.getName()+" " + l.getAddress()+" ");
        }
    }

    //return replaceLibraryById();
}


public static void main(String args[]) throws IOException 
{
    Scanner sc=new Scanner(System.in);
    Library[] objArray=new Library[5];

    System.out.println("Create the 5 class data below : ");

    for(int i=0;i<objArray.length;i++)
    {
        System.out.print("enter class id : ");
        int id=sc.nextInt();
        sc.nextLine();

        System.out.print("enter class name : ");
        String name=sc.nextLine();

        System.out.print("enter class Address : ");
        String address=sc.nextLine();

        System.out.println("id :" + id + " name : " + name + " Address :" + address);
        objArray[i]=new Library(id,name,address);
    }

    System.out.println("Search for a class : ");

    System.out.print("enter class id : ");
    int inputid=sc.nextInt();
    sc.nextLine();

    System.out.print("enter class name : ");
    String inputname=sc.nextLine();

    System.out.print("enter class Address : ");
    String inputadd=sc.nextLine();

    Library inputlib=new Library(inputid,inputname,inputadd);
    replaceLibraryById(objArray, inputlib);
}
}
import java.util.Scanner; 



 class MainSector {
    String Primary, Secondary;

    MainSector(String Primary, String Secondary){
        this.Primary = Primary;
        this.Secondary = Secondary;
    }

MainSector(int Primary, int Secondary) {
    this.Primary = Integer.toString(Primary);
    this.Secondary = Integer.toString(Secondary);
    }

//Note the changes made to this method!
    boolean Compare(MainSector x){
        return ((x.Primary.equals(Primary)) && (x.Secondary.equals(Secondary)));

        }
} //End MainSector


public class Test {
    public static void main(String[] args) {
        Scanner u = new Scanner(System.in);

        System.out.println("Enter String:");
        MainSector Sector1 = new MainSector(u.nextLine(),u.nextLine());

        System.out.println("Enter String:");
        MainSector Sector2 = new MainSector(u.nextLine(),u.nextLine());

        System.out.println("Enter Integer:");
        MainSector Sector3 = new MainSector(u.nextInt(),u.nextInt());


        System.out.println(Sector1.Compare(Sector2));
        System.out.println(Sector1.Compare(Sector3));
        System.out.println(Sector2.Compare(Sector3));

        u.close();
    } //End main
} //End Test
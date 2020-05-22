public class Main {

    public static void main(String args[]) {    
        new Main();
    }

    { System.out.println(this.x); } //Error here

    int x=1;
}
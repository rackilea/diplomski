public class packers{

public int [] wins = new int[5];

    public int[] getWins() {
        return wins;
    }

    public void setWins(int[] wins) {
        this.wins = wins;
    }

}       

public class Test{
public static void main(String[] args) {
         Packers p = new Packers();
         // to pass single element to an existing array
         p.getWins()[index] = 2;

         // or you can create entire array and just pass it to setWins method.
          p.setWins(new int[]{2, 4, 6});
         }
}
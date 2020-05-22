enum Season{
    Skyrise,Toss_Up, Sack_Attack;

    @Override
    public String toString() {
        switch(this){
            case Skyrise: return "Skyrise";
            case Toss_Up: return "Toss%20Up";
            case Sack_Attack: return "Sack_Attack";
            default: return "";
        }
    }
}
public class main{
    public static void printSeason(Seasons seasons){
        System.out.println(seasons);
    }
    public static void main(String[] args) {
        Seasons e = Seasons.Skyrise;
        printSeason(e);
        System.out.println(e);
    }
}
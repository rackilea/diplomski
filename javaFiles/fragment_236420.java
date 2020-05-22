import java.util.ArrayList;
public class LexicographicOrdering
{
   public static void main (String [] args){
        ArrayList<String> teachers = new ArrayList<String>();
        teachers.add("Turnbow");
        teachers.add("Dyvig");
        teachers.add("Williams");
        teachers.add("Houge");
        teachers.add("Allaire");
        teachers.add("Violette");
        teachers.add("Dorgan");
        System.out.println(teachers);
        order(teachers);
   }
    public static void order(ArrayList<String> teachers ){
        ArrayList<String> ordered = new ArrayList<String>();
        for(int i = 0; i < teachers.size(); i++){
            String str = teachers.get(i);
            for(int j = 1; j < teachers.size(); j++){
                if(str.compareTo(teachers.get(j)) > 0){
                    str = teachers.get(j);  
                }
            }
            i =- 1;
            ordered.add(str);
            teachers.remove(str);
        }
        System.out.print(ordered);
   }
}
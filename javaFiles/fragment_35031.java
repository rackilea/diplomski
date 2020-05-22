import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Check   {
    private final Integer checkNumber;

    public Check(Integer newCheckNumber) {
        this.checkNumber = newCheckNumber;
    }
    public Integer getCheckNumber() {
        return this.checkNumber;
    }
    public static void main( String [] args ) {
        List<Check> list = new ArrayList<Check>();

        list.add(new Check(445));
        list.add(new Check(101));
        list.add(new Check(110));
        list.add(new Check(553));
        list.add(new Check(123));

        Collections.sort( list, new Comparator<Check>() {
           public int compare( Check one, Check two ){
               return one.getCheckNumber() - two.getCheckNumber();
           } 
        });
        for( Check item : list ) {
            System.out.println( item.getCheckNumber() );
        }
    }
}
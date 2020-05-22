import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class change_generation {

  static int jj=1;

  public static void generatechange(float amount,LinkedList<Float> denominations, 
                                  HashMap<Float,Integer> useddenominations) {
    if(amount<0)
        return;
    if(amount==0) {
        Iterator<Float> it = useddenominations.keySet().iterator();
        while(it.hasNext()) {
            Float val = it.next();
            System.out.println(val +" :: "+useddenominations.get(val));
        }
        System.out.println("**************************************");

        return;
    }

    for(Float denom : denominations) {
        if(amount-denom < 0)
            continue;
        if(useddenominations.get(denom)== null)
            useddenominations.put(denom, 0);

        useddenominations.put(denom, useddenominations.get(denom)+1);
        generatechange(amount-denom, denominations, useddenominations);
        useddenominations.put(denom, useddenominations.get(denom)-1);
    }
  }

  public static void main(String[] args) {
    float amount = 2.0f;
    float nikle=0.25f;
    float dollar=1.0f;
    float ddollar=2.0f;

    LinkedList<Float> denominations = new LinkedList<Float>();

    denominations.add(ddollar);
    denominations.add(dollar);
    denominations.add(nikle);

    HashMap<Float,Integer> useddenominations = new HashMap<Float,Integer>();
    generatechange(amount, denominations, useddenominations);
  }
}
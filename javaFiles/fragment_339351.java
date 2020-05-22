package droolsexample

// list any import classes here.
import com.sample.ItemCity;
import java.math.BigDecimal;

// declare any global variables here
dialect "java"
rule "Pune Medicine Item"

   when
      $item : ItemCity (purchaseCity == ItemCity.City.PUNE,
                       typeofItem == ItemCity.Type.MEDICINES)

   then
      BigDecimal tax = new BigDecimal(0.0);
      $item.setLocalTax(tax.multiply($item.getSellPrice()));
end
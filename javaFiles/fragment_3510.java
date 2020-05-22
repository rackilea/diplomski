import java.util.HashSet;
import java.util.Collections;
import java.text.DateFormatSymbols;

class Test {
  public static void main(String[] args) {

    HashSet<String> months = new HashSet<String>(24);  

    Collections.addAll(months, DateFormatSymbols.getInstance().getMonths());
    Collections.addAll(months, DateFormatSymbols.getInstance().getShortMonths());

    System.out.println(months.contains(args[0]));

  }
}
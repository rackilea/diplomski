Raw Match Pattern:

  value='[A-Za-z]+\,[0-9]+\,([A-Za-z0-9]+)\,([A-Za-z0-9]+)'>[A-Za-z0-9]+\s-\s(.*)?\s\(

Java Code Example:

import java.util.regex.Pattern;
import java.util.regex.Matcher;
class Module1{
  public static void main(String[] asd){
    String sourcestring = "source string to match with pattern";
    Pattern re = Pattern.compile("value='[A-Za-z]+\\,[0-9]+\\,([A-Za-z0-9]+)\\,([A-Za-z0-9]+)'>[A-Za-z0-9]+\\s-\\s(.*)?\\s\\(");
    Matcher m = re.matcher(sourcestring);
    int mIdx = 0;
    while (m.find()){
      for (int groupIdx = 0; groupIdx < m.groupCount()+1; groupIdx++){
        System.out.println( "[" + mIdx + "][" + groupIdx + "] = " + m.group(groupIdx));
      }
      mIdx++;
    }
  }
}

$matches Array:
(
  [0] => Array
    (
      [0] => value='C,201301,F110,JEWL1050'>JEWL1050 - Industry Skills I (
      [1] => value='C,201301,F114,JEWL1050'>JEWL1050 - Industry Skills I (
      [2] => value='C,201301,F114,JEWL1054'>JEWL1054 - Jewellery Rendering & Illustra (
      [3] => value='C,201301,F110,JEWL2029'>JEWL2029 - Production Techniques B (
      [4] => value='C,201301,F114,JEWL2029'>JEWL2029 - Production Techniques B (
      [5] => value='C,201301,LIAD,LANG9066'>LANG9066 - Italian For Beginners (
      [6] => value='C,201301,T302,LAW1151'>LAW1151 - Canandian & Environmental Law (
      [7] => value='C,201301,T305,LAW1151'>LAW1151 - Canandian & Environmental Law (
      [8] => value='C,201301,F402,LAW1152'>LAW1152 - International Law & Agreements (
      [9] => value='C,201301,T302,LAW3201'>LAW3201 - Protection Legislation (
      [10] => value='C,201301,T303,LAW3201'>LAW3201 - Protection Legislation (
      [11] => value='C,201301,T304,LAW3201'>LAW3201 - Protection Legislation (
    )

  [1] => Array
    (
      [0] => F110
      [1] => F114
      [2] => F114
      [3] => F110
      [4] => F114
      [5] => LIAD
      [6] => T302
      [7] => T305
      [8] => F402
      [9] => T302
      [10] => T303
      [11] => T304
    )

  [2] => Array
    (
      [0] => JEWL1050
      [1] => JEWL1050
      [2] => JEWL1054
      [3] => JEWL2029
      [4] => JEWL2029
      [5] => LANG9066
      [6] => LAW1151
      [7] => LAW1151
      [8] => LAW1152
      [9] => LAW3201
      [10] => LAW3201
      [11] => LAW3201
    )

  [3] => Array
    (
      [0] => Industry Skills I
      [1] => Industry Skills I
      [2] => Jewellery Rendering & Illustra
      [3] => Production Techniques B
      [4] => Production Techniques B
      [5] => Italian For Beginners
      [6] => Canandian & Environmental Law
      [7] => Canandian & Environmental Law
      [8] => International Law & Agreements
      [9] => Protection Legislation
      [10] => Protection Legislation
      [11] => Protection Legislation
    )
)
CREATE JAVA SOURCE NAMED Phonetics AS
import org.apache.commons.codec.language.ColognePhonetic;

public class Phonetics {
  public static String encode(
    final String text
  ){
    final ColognePhonetic cp = new ColognePhonetic();
    return cp.encode( text );
  }
}
/

CREATE FUNCTION get_phonetic_string(i_string VARCHAR2) RETURN VARCHAR2 AS
  LANGUAGE JAVA NAME 'Phonetics.encode( java.lang.String ) return java.lang.String';
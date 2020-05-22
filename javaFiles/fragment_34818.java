import java.text.SimpleDateFormat;
import java.text.ParseException;
//--------------------------------------------------------------------------------
boolean isDate(String check) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    if (check.trim().length != dateFormat.toPattern().length) {
        return false;
    }
    dateFormat.setLenient(false);
    try {  
        dateFormat.parse(check.trim());
    } catch (ParseException pe) {
        return false;
    }
    return true;
}
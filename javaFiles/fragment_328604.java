import java.lang.Character;
import java.util.ArrayList;
import java.util.List;

List<Integer> code_points = new ArrayList<Integer>();
for (int cp = Character.MIN_CODE_POINT; cp < Character.MAX_CODE_POINT; ++cp) {
    if (Character.UnicodeScript.of(cp) == Character.UnicodeScript.GREEK) {
        code_points.add(cp);
    }
}
import java.util.regex.Pattern;
import java.util.regex.Matcher;

[...]

String fileName = "SuSa_Q2Factory_2012-08.xls";
Pattern p = Pattern.compile(".*([0-9]{4})[-_., ]([0-9]{1,2})\\.(xls|xlsx)");
Matcher m = p.matcher(fileName);
if (m.matches()) {
    int year = Integer.parseInt(m.group(1));
    int month = Integer.parseInt(m.group(2));
    System.out.printf("year = %d, month = %d\n", year, month);
}
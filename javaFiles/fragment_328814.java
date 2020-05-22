import java.util.regex.Matcher;
import java.util.regex.Pattern;

final String regex = "((?:^[^;\\v]*;|\\G(?!\\A))[^;\\v]*);";
final String string = "    4231;\"Swiss Federal Railways (SBB; CFF; FFS)\"\n"
     + "    67;\"Hershey Co; The\"";
final String subst = "$1";

final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
final Matcher matcher = pattern.matcher(string);

// The substituted value will be contained in the result variable
final String result = matcher.replaceAll(subst);

System.out.println("Substitution result: " + result);
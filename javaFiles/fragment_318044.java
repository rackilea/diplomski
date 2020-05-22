import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.MatchResult;

class RegexTester {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        String regex = scanner.nextLine();
        StringBuilder input = new StringBuilder();
        while (scanner.hasNextLine()) {
            input.append(scanner.nextLine()).append('\n');
        }

        Set<String> namedGroups = getNamedGroupCandidates(regex);

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        int groupCount = m.groupCount();

        int matchCount = 0;

        if (m.find()) {
            // Remove invalid groups
            Iterator<String> i = namedGroups.iterator();
            while (i.hasNext()) {
                try {
                    m.group(i.next());
                } catch (IllegalArgumentException e) {
                    i.remove();
                }
            }

            matchCount += 1;
            System.out.println("Match " + matchCount + ":");
            System.out.println("=" + m.group() + "=");
            System.out.println();
            printMatches(m, namedGroups);

            while (m.find()) {
                matchCount += 1;
                System.out.println("Match " + matchCount + ":");
                System.out.println("=" + m.group() + "=");
                System.out.println();
                printMatches(m, namedGroups);
            }
        }
    }

    private static void printMatches(Matcher matcher, Set<String> namedGroups) {
        for (String name: namedGroups) {
            String matchedString = matcher.group(name);
            if (matchedString != null) {
                System.out.println(name + "=" + matchedString + "=");
            } else {
                System.out.println(name + "_");
            }
        }

        System.out.println();

        for (int i = 1; i < matcher.groupCount(); i++) {
            String matchedString = matcher.group(i);
            if (matchedString != null) {
                System.out.println(i + "=" + matchedString + "=");
            } else {
                System.out.println(i + "_");
            }
        }

        System.out.println();
    }

    private static Set<String> getNamedGroupCandidates(String regex) {
        Set<String> namedGroups = new TreeSet<String>();

        Matcher m = Pattern.compile("\\(\\?<([a-zA-Z][a-zA-Z0-9]*)>").matcher(regex);

            while (m.find()) {
                namedGroups.add(m.group(1));
            }

            return namedGroups;
        }
    }
}
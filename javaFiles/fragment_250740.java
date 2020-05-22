package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {

    public static void main(String[] args) throws IOException {

        final Pattern APP_PATTERN = Pattern.compile("\\/([^/]*)\\.app\\/Contents");

        Set<String> apps = new TreeSet<>();

        String line;
        Process p = Runtime.getRuntime().exec("ps -e");
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while (((line = input.readLine()) != null)) {
            if (!line.contains(" /System/") &&
                !line.contains("/Library/") &&
                !line.contains("/Application Support/")) {
                Matcher m = APP_PATTERN.matcher(line);
                if (m.find()) {
                    apps.add( m.group(1) );
                }
            }
        }
        System.out.println("Apps: " + apps);
        input.close();
    }
}
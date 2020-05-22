import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        String gradleFileContent = "group 'com.shan.sample.gradle'\n" +
                "version '1.0-SNAPSHOT'\n" +
                "\n" +
                "apply plugin: 'java'\n" +
                "apply plugin: 'application'\n" +
                "apply plugin: 'maven'\n" +
                "\n" +
                "sourceCompatibility = 1.8\n" +
                "\n" +
                "\n" +
                "mainClassName = 'com.shan.sample.gradle.SampleProgram'\n" +
                "\n" +
                "dependencies {\n" +
                "    testCompile group: 'junit', name: 'junit', version: '4.12'\n" +
                "}\n";

        Pattern p = Pattern.compile("(version )([A-Z0-9.'/-]+)");
        Matcher m = p.matcher(gradleFileContent);

        if (m.find()) {
            System.out.println(m.group(2));
        }
    }
}
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;

public class IDLParserTest {

    public static void main(String[] args) {
        parse("common.idl");
    }

    private static void parse(String file) {
        InputStream is = IDLParserTest.class.getResourceAsStream(file);
        Scanner scanner = new Scanner(is);

        while (parseEnum(scanner))
            ;
    }

    protected static boolean parseEnum(Scanner scanner) {
        if (!scanner.hasNext())
            return false;
        String strEnum = scanner.findWithinHorizon("enum", 8192);
        if (strEnum == null)
            return false;
        if (!strEnum.equals("enum"))
            return true;
        StringBuilder javaCode = new StringBuilder();
        String strClass = scanner.next();
        scanner.next(); // skip open bracket
        javaCode.append("package com.mycompany; ");
        javaCode.append("public enum " + strClass + " { ");
        while (scanner.hasNext()) {
            String f = scanner.next();
            // System.out.println("<<<" + f);
            if (f.equals("};")) {
                javaCode.append(" }");
                File outFile = new File(strClass + ".java");
                // TODO: Write javaCode.toString() to outFile
                System.out.println("Wrote: " + outFile + ":" + javaCode.toString());
                return true;
            } else {
                javaCode.append(f);
            }
        }
        return true;
    }

}
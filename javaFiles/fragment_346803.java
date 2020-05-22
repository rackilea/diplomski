public class Main {
    public static void main(String[] args)
    {

        String version1 = "4.10";
        String version2 = "4.5";

        compareVersions(version1, version2);
    }

    private static void compareVersions(String v1, String v2) {
        String[] versionSplit1 = v1.split("\\.");
        String[] versionSplit2 = v2.split("\\.");
        if (versionSplit1[0].equals(versionSplit2[0])) {
            if (Integer.parseInt(versionSplit1[1]) > (Integer.parseInt(versionSplit2[1]))) {
                System.out.println(v1 + " is bigger than " + v2);
            } else if (Integer.parseInt(versionSplit1[1]) == (Integer.parseInt(versionSplit2[1]))){
                System.out.println(v1 + " is equal to " + v2);
            } else {
                System.out.println(v2 +  " is bigger than " + v1);
            }
        } else if (Integer.parseInt(versionSplit1[0]) > Integer.parseInt(versionSplit2[0])) {
            System.out.println(v1 + " is bigger than " + v2);
        } else {
            System.out.println(v2 + " is bigger than " + v1);
        }
    }
}
public static String getIdeaVersionTheDumbWay() {
    String result="unknown";
    final String binPath = System.getProperty("idea.launcher.bin.path");
    if (binPath.contains("IntelliJ IDEA")) {
        final String[] strings = binPath.split(System.getProperty("file.separator")+System.getProperty("file.separator"));
        for (String s : strings) {
            final int startIndex = s.indexOf("IntelliJ IDEA");
            if (startIndex >= 0) {
                result= s.substring(startIndex + 14);
            }

        }

    }

    return result;
}
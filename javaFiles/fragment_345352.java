static protected String findJavaw() {
    Path pathToJavaw = null;
    Path temp;

    /* Check in Registry: HKLM\Software\JavaSoft\Java Runtime Environement\<CurrentVersion>\JavaHome */
    String keyNode = "HKLM\\Software\\JavaSoft\\Java Runtime Environment";
    List<String> output = new ArrayList<>();
    executeCommand(new String[] {"REG", "QUERY", "\"" + keyNode + "\"", 
                                 "/v", "CurrentVersion"}, 
                   output);
    Pattern pattern = Pattern.compile("\\s*CurrentVersion\\s+\\S+\\s+(.*)$");
    for (String line : output) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            keyNode += "\\" + matcher.group(1);
            List<String> output2 = new ArrayList<>();
            executeCommand(
                    new String[] {"REG", "QUERY", "\"" + keyNode + "\"", 
                                  "/v", "JavaHome"}, 
                    output2);
            Pattern pattern2 
                    = Pattern.compile("\\s*JavaHome\\s+\\S+\\s+(.*)$");
            for (String line2 : output2) {
                Matcher matcher2 = pattern2.matcher(line2);
                if (matcher2.find()) {
                    pathToJavaw = Paths.get(matcher2.group(1), "bin", 
                                            "javaw.exe");
                    break;
                }
            }
            break;
        }
    }
    try {
        if (Files.exists(pathToJavaw)) {
            return pathToJavaw.toString();
        }
    } catch (Exception ignored) {}

    /* Check in 'C:\Windows\System32' */
    pathToJavaw = Paths.get("C:\\Windows\\System32\\javaw.exe");
    try {
        if (Files.exists(pathToJavaw)) {
            return pathToJavaw.toString();
        }
    } catch (Exception ignored) {}

    /* Check in 'C:\Program Files\Java\jre*' */
    pathToJavaw = null;
    temp = Paths.get("C:\\Program Files\\Java");
    if (Files.exists(temp)) {
        try (DirectoryStream<Path> dirStream 
                = Files.newDirectoryStream(temp, "jre*")) {
            for (Path path : dirStream) {
                temp = Paths.get(path.toString(), "bin", "javaw.exe");
                if (Files.exists(temp)) {
                    pathToJavaw = temp;
                    // Don't "break", in order to find the latest JRE version
                }                    
            }
            if (pathToJavaw != null) {
                return pathToJavaw.toString();
            }
        } catch (Exception ignored) {}
    }

    /* Check in 'C:\Program Files (x86)\Java\jre*' */
    pathToJavaw = null;
    temp = Paths.get("C:\\Program Files (x86)\\Java");
    if (Files.exists(temp)) {
        try (DirectoryStream<Path> dirStream 
                = Files.newDirectoryStream(temp, "jre*")) {
            for (Path path : dirStream) {
                temp = Paths.get(path.toString(), "bin", "javaw.exe");
                if (Files.exists(temp)) {
                    pathToJavaw = temp;
                    // Don't "break", in order to find the latest JRE version
                }                    
            }
            if (pathToJavaw != null) {
                return pathToJavaw.toString();
            }
        } catch (Exception ignored) {}
    }

    /* Check in 'C:\Program Files\Java\jdk*' */
    pathToJavaw = null;
    temp = Paths.get("C:\\Program Files\\Java");
    if (Files.exists(temp)) {
        try (DirectoryStream<Path> dirStream 
                = Files.newDirectoryStream(temp, "jdk*")) {
            for (Path path : dirStream) {
                temp = Paths.get(path.toString(), "jre", "bin", "javaw.exe");
                if (Files.exists(temp)) {
                    pathToJavaw = temp;
                    // Don't "break", in order to find the latest JDK version
                }                    
            }
            if (pathToJavaw != null) {
                return pathToJavaw.toString();
            }
        } catch (Exception ignored) {}
    }

    /* Check in 'C:\Program Files (x86)\Java\jdk*' */
    pathToJavaw = null;
    temp = Paths.get("C:\\Program Files (x86)\\Java");
    if (Files.exists(temp)) {
        try (DirectoryStream<Path> dirStream 
                = Files.newDirectoryStream(temp, "jdk*")) {
            for (Path path : dirStream) {
                temp = Paths.get(path.toString(), "jre", "bin", "javaw.exe");
                if (Files.exists(temp)) {
                    pathToJavaw = temp;
                    // Don't "break", in order to find the latest JDK version
                }                    
            }
            if (pathToJavaw != null) {
                return pathToJavaw.toString();
            }
        } catch (Exception ignored) {}
    }

    return "javaw.exe";   // Let's just hope it is in the path :)
}
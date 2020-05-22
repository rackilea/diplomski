String filename = "APP-TEST-file.20161115.1";
// replace two consecutive dots with a single dot
filename = filename.replaceAll("\\.+", ".");
// replace two consecutive forward slash with a single forward slash
filename = filename.replaceAll("/+", "/");
// replace two consecutive baskslash with a backslash
filename = filename.replaceAll("\\\\+", "\\\\");
// allow alphanumeric characters, dots and both type of slashes
filename = filename.replaceAll("[^A-Za-z0-9./\\\\]+", "");
System.out.println(filename);
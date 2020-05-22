// making use of lastIndexOf
String subPath = path.substring(path.lastIndexOf("/"));

// make use of file class
String subPath = new File(path).getName();

// make use of String split
String[] parts = path.split("/");
String subPath = parts[parts.length - 1];

// modification on your own code
public static String splitPath(String path) {
    int index = path.indexOf("/");
    if (index == -1)
        return path;
    else 
        return splitPath(path.substring(index + 1));
}
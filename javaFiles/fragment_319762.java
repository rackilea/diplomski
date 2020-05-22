String line;
while ((line = readLine()) != null) {
    String packageName = null, className = null;
    int indexOfPackage = line.indexOf("package");
    int indexOfClass = line.indexOf("class");
    int indexOfBrace = line.indexOf('{');
    int indexOfSemiColon = line.indexOf(';');
    int classStringLength = "class ".length();
    int packageStringLength = "package ".length();
    if (indexOfPackage != -1) {
        packageName = line.substring(indexOfPackage + packageStringLength, indexOfSemiColon);
    }
    if (indexOfClass != -1) {
        className = line.substring(indexOfClass + classStringLength, indexOfBrace);
    }

    System.out.println("Package Name: " + packageName + " ");
    System.out.print("Class Name: " + className + " ");
}
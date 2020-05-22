DirectoryScanner scanner = new DirectoryScanner();  
if (!inputPath.startsWith("/") || inputPath.startsWith(".")) {  
    scanner.setBasedir(".");  
}  
scanner.setIncludes(new String[]{inputPath});  
scanner.setCaseSensitive(false);  
scanner.scan();  
String[] foundFiles = scanner.getIncludedFiles();
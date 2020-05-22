File folder = new File("");
File[] listOfFiles = folder.listFiles();

boolean isItThere = false;
for (File file : listOfFiles) {
    if (file.isFile()) {
        if (file.getName().equals("Text1.txt")) {
            isItThere = true;
        }
        System.out.println(file.getName());
    } else if (file.isDirectory()) {
        System.out.println("Directory " + file.getName());
    }
}

//Try to match file to email address

if (isItThere) {
    System.out.println("MATCH");
} else {
    System.out.println("NOT MATCHED");
}
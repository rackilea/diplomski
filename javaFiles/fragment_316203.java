for(File f : files) {
    if (f.getName().matches(".*_.*\\.html")) {
        System.out.print("Processing file: " + f.getName()+ "\n");
        String[] fileSplit = f.getName().split("_");
        towns.add(fileSplit[0]);
    }
}
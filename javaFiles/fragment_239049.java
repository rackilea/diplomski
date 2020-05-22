String[] split = listOfFiles.split("_")
if(split.length > 1) {
    if(split[0].contains("MONTHLY")) { //unique case
        System.out.println(split[1].substring(0, 3) + " " + split[2]);
    }
    else {
        for(int i = 1; i < split.length(); i++) {
            System.out.print(split[i] + " ");
        }
        System.out.println("");
    }
}
else {
    System.out.println("\n" + listOfFiles + "\n");
}
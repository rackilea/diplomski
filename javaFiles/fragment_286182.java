while(sc.hasNextLine()){
    String line = sc.nextLine();
    String[] details = line.split("\\s+");
    if(details.length < 11) continue; // skip this iteration
    ...
}
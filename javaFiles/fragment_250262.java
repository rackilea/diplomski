try (Bufferedreader br = new BufferedReader(new FileReader(file))) {
    String line;
    StringBuilder concatenatedLine = new StringBuilder();
    List<String> formattedStrings = new ArrayList<String>();
    while((line = br.readLine()) != null){

        //If this one needs to be concatenated with the next,
        if( line.charAt(line.length() -1) == '\\' ){ 
            //strip the last character from the string
            line = line.substring(0, line.length()-1); 
            //and add it to the StringBuilder
            concatenatedLine.append(line);
        }
        //If it doesn't, this is the end of this concatenated line
        else{
            concatenatedLine.append(line);
            //Add it to the formattedStrings collection.
            formattedStrings.add(concatenatedLine.toString());
            //Clear the StringBuilder
            concatenatedLine.setLength(0);
        }
    }

    //The formattedStrings arrayList contains all of the strings formatted for use.
}
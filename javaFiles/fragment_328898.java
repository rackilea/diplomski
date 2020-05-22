ArrayList<String> organisms = new ArrayList<String>();
boolean printLines = false;
StringBuilder organism = new StringBuilder();
while((currentLine = br.readLine()) != null) {
    if (printLines) {
        if (currentLine.startsWith(">")) {
            // We have reached the next organism, so stop printing
            printLines = false;
            // Add the current organism to our collection
            organisms.add(organism.toString());
            // Clear the StringBuilder, ready for the next organism
            organism.setLength(0)
        }
        else
        {
            // We are still printing the current organism
            organism.append(currentLine);
        }
    }

    if(currentLine.startsWith(organismId)) {
        // Print this line, and start printing all lines after this
        organism.append(currentLine);
        printLines = true;
    }
}
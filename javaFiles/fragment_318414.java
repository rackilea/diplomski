while (fileReader.hasNextLine()) { 
    String line = fileReader.nextLine();
    contents[rowIndex] = fileReader.split(",\\s*");
    System.out.println("At (" + rowIndex + "): "
            + Arrays.toString(contents[rowIndex]));
    rowIndex++;
}
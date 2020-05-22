for (int j=0; j < runCopy; j++) {
    for (int k=0; k < numberOfCopies; k++) {  
        final String line = textLines[k];
        write.write(line);  
        write.newLine();  
    }
}
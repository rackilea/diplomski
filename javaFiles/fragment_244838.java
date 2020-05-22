for (int j=0; j<502; j++) {  
    thisLine=br.readLine(); 
    if (thisLine != null) {
        temp = thisLine.split(delimiter);  
        for (int i = 0; i < 2; i++) {  
            hexLibrary[j][i]=temp[i];  
        }  
    } else {
        // report error: premature end of input file
        break; // no point in continuing to loop
    }
}
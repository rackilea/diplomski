// P R O C E S S   I N T   F I L E 
    while ( intFile.hasNextInt() ) // i.e. while there are more ints in the file
    {   
        if ( intCount == intList.length ) 
            intList = upSizeArr( intList );
        intList[intCount] = intFile.nextInt();
        intCount++;
    } //END WHILE intFile
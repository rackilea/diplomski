// P R O C E S S   S T R I N G    F I L E
    while ( wordFile.ready() ) // i.e. while there is another line (word) in the file
    {   
        if ( wordCount == wordList.length ) 
            wordList = upSizeArr( wordList );
        wordList[wordCount] = wordFile.readLine();
        wordCount++;
    } //END WHILE wordFile
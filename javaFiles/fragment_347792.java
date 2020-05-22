while(true){
    int bytesRead = stream.read(tmpBuffer);
    // if -1, EOF
    if(bytesRead < 0)
        break;

    (...)

    // WRONG LOGIC !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // if we read the last chunk of data, and found EOF
    if(bytesRead < tmpBufferArrayLength)
        break;
    // WRONG LOGIC !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
}
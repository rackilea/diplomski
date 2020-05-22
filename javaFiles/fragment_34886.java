try {
   while((line = bufRdr.readLine()) != null)
    {
    // read line by line and append some string to the line
    //pseudo code
    newline = line + "yourtext";
    outputstreamtootherfile.write(newline);

    }
}
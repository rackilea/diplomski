// do what we came here to do, read the input
    @SuppressWarnings("resource")
    BufferedReader br = new BufferedReader(new FileReader( input ));

    try 
    {

        //now that we're reading the file we need to send it on
        //to the regex extractot after we're through
        RegEx regex_extractor = new RegEx();

        String line;
        while ((line = br.readLine()) != null) 
        {
            regex_extractor.match_regex_patterns(line, ontology, sentences, subject2index, object2index, joints);
        }
    } 
    catch (IOException ex) 
    {
        // ...
    } 
    finally 
    {
        if (br != null) 
        {
            try 
            {
                br.close();
            } 
            catch (IOException ex) 
            {
                // ignore
            }
        }
    }
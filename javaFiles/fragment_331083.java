while ((line = in.readLine()) != null) { // here you read a line
        lemma_match = line.split(";")[3];
        frequency = 1;
        while((in.readLine().split(";")[3]).equals(lemma_match)){ // here you read
                                                                  // another line
            frequency++;
            line = in.readLine(); // here you read another line                   
        }
String lemma_match = "";
    while ((line = in.readLine()) != null) {
        String new_lemma_match = line.split(";")[3];
        if (!lemma_match.equals(new_lemma_match)) { // start count for a new lemma
            if (!lemma_match.equals("")) {
                System.out.println(target + ":" + source +":"+lemma_match + ":" + frequency);
            }
            lemma_match=new_lemma_match;
            frequency = 1; // initialize frequency for new lemma
        } else {
            frequency++; // increase frequency for current lemma
        }
    }
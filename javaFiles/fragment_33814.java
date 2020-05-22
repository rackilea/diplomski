//for each document, except for the last one
for (int k = 0; k < collect.size() - 1; k++) {
    //for each line i in the current document k
    for (int i = 0; i < collect.get(k).size(); i++) {
        //for each document m after k
        for (int m = k + 1; m < collect.size(); m++) {
            //for each line j in document m
            for (int j = 0; j < collect.get(m).size(); j++) {
                //do your stuff by comparing
                //collect.get(k).get(i).getSentence()
                //WITH
                //collect.get(m).get(j).getSentence()
            }
        }
    }
}
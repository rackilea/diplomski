public Chromosome crossOver(Chromosome father, Chromosome mother){

    Chromosome replacement = new Chromosome();
    replacement.getPairsList().clear(); // get rid of the original 10 pairs

    int pos1 = r.nextInt(father.getPairsList().size());

    while(pos1 >= 10)
        pos1 = r.nextInt(father.getPairsList().size());

        for(int i = 0; i < pos1; i++){
            MyPair tempPair = father.getPairsList().get(i);
            replacement.getPairsList().add(tempPair.makeCopy()); // appended copy instead of setting ith
        }           

        for(int i = pos1; i < mother.getPairsList().size() - 1; i++){
            MyPair tempPair = mother.getPairsList().get(i);

            // ArrayList keeps trying to set out of bounds here
            replacement.getPairsList().add(tempPair.makeCopy()); // append copy instead of setting ith
        }

        return replacement;
    }
for (IndexWord word : collection) {

            Synset[] senses = word.getSenses();
            for(Synset sense:senses){
                if(sense.getGloss().toLowerCase().contains(token)){return true;}
            }

        }
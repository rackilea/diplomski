for(IndexWord word : collection) {
                Synset[] senses = word.getSenses();
                if(senses != null && senses.length > 0
                        && senses[0].toString().toLowerCase().contains(token)) {
                    return true;
                }
            }
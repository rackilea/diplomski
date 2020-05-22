public static boolean is_Missing_WordNet(String r,String posTag){
   // System.out.println("inside is_missing_Wordnet "+r);
          boolean flag=true;
              configureJWordNet();
              Dictionary dictionary = Dictionary.getInstance();
              IndexWord word;
        try {
            if(posTag.equals("VBG"))//Verb
                 { word = dictionary.lookupIndexWord(POS.VERB, r);}
            else {word = dictionary.lookupIndexWord(POS.NOUN, r);}

            Synset[] senses = word.getSenses();

                if(senses!=null && senses.length>0){
                 if(senses[0].toString().toLowerCase().contains(r)|| senses[0].toString().contains(r.replace(" ","_")))
                 { System.out.println("sense;;;; "+senses[0].toString());flag=false;}
                  }                                       
                else{System.out.println("wordnet has no sense of "+r );return true; }


                }
        catch(NullPointerException ex){return true;}
         catch (JWNLException ex) {return true;
                    }
        return flag; 
    }
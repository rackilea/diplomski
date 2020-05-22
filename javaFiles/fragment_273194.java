Term firstTerm = new Term("jobTitle", "entry");
    **  Term secondTerm = firstTerm.createTerm("ar");

      Term[] tTerms = new Term[] { firstTerm, secondTerm };
      MultiPhraseQuery multiPhrasequery = new MultiPhraseQuery();

      try {
         File index = new File("I:/com.rhc.rayport.model.JobReq");
         Directory indexDirectory = FSDirectory.open(index); 
         System.out.println(indexDirectory);
         PrefixTermEnum reader = new PrefixTermEnum(IndexReader.open(indexDirectory), secondTerm);
         System.out.println(reader.toString());

         List<Term> termList = new LinkedList<Term>();
         while (reader.docFreq() != -1) {
               Term t = reader.term();
               System.out.println(t);
            if (t.field().equals("jobTitle") ||  t.text().startsWith(secondTerm.text())) {
                termList.add(t);
            }
           reader.next();              
         }

         Term[] terms = termList.toArray(new Term[0]);
         multiPhrasequery.add(firstTerm);
       **  multiPhrasequery.add(terms);
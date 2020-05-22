Collator collator = Collator.getInstance(new Locale("ar"));  
        ICUCollationKeyAnalyzer analyzer = new
        ICUCollationKeyAnalyzer(collator);
        RAMDirectory ramDir = new RAMDirectory();   
        IndexWriter writer = new IndexWriter(ramDir, analyzer, true, IndexWriter.MaxFieldLength.LIMITED);   
        Document doc = new Document();   
        doc.add(new Field("content","\u0633\u0627\u0628", Field.Store.YES,Field.Index.ANALYZED));   
        writer.addDocument(doc);   
        writer.close();
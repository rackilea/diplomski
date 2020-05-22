Directory dir = <your dir>;
IndexReader index = DirectoryReader.open(dir);
IndexSearcher searcher = new IndexSearcher(index);
searcher.setSimilarity(new KmancSimilarity());

continue your code...
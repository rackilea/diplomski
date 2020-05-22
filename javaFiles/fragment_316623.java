Query query1 = new TermQuery(new Term("your_default_field", "apple"));
query1.setBoost(0.2);

Query query2 = new TermQuery(new Term("your_default_field", "growers"));
query2.setBoost(0.7);

Query query3 = new TermQuery(new Term("your_default_field", "fruit"));
query3.setBoost(0.9);

Query query4 = new TermQuery(new Term("your_default_field", "ipad"));
query4.setBoost(0.05);

Query query5 = new TermQuery(new Term("your_default_field", "mac"));
query5.setBoost(0.06);

BooleanQuery combining = new BooleanQuery();
combining.add(query1, Occur.SHOULD);  
combining.add(query2, Occur.SHOULD);  // and so on and so forth
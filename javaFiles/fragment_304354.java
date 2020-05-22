HashMap<String, Object> map = new HashMap<String, Object>();
    map.put("Title", "INDEX");
    map.put("Action", "GoTo");
    map.put("Page", String.format("%d Fit", 8));
    ArrayList<HashMap<String, Object>> kids = new ArrayList<HashMap<String,Object>>();

    for(BookMark book : BookMarks) {
        HashMap<String, Object> kid = new HashMap<String, Object>();
        kid.put("Title", book.getDescription());
        kid.put("Action", "GoTo");
        kid.put("Page", String.format("%d Fit", book.getPageNumber()));

        ArrayList<HashMap<String, Object>> leafs = new ArrayList<HashMap<String,Object>>();
        for(BookMark books : book.getLeaf()) {
            HashMap<String, Object> leaf = new HashMap<String, Object>();
            leaf.put("Title", books.getDescription());
            leaf.put("Action", "GoTo");
            leaf.put("Page", String.format("%d Fit", books.getPageNumber()));
            leafs.add(leaf);
        }
        kid.put("Kids", leafs);
        kids.add(kid);
    }

    map.put("Kids", kids);
    ArrayList<HashMap<String, Object>> outlines = new ArrayList<HashMap<String,Object>>();
    outlines.add(map);
    PdfReader reader = new PdfReader(env.getProperty("path.generated.pdf").concat(fileName));
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(env.getProperty("path.generated.pdf").concat(catalogInfo.getCatalogName().trim().concat("raw1")).concat(".pdf")));
    stamper.setOutlines(outlines);
    stamper.setFullCompression();
    stamper.close();
    reader.close();
    File file = new File(env.getProperty("path.generated.pdf").concat(fileName)); 
    file.delete();
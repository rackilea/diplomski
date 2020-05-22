int i = 0;
    File input = new File(result_doc);
    Document doc = Jsoup.parse(input, "UTF-8");
    for( Element img : doc.select("img[src]") ) {
        img.attr("src",array[i]); // set attribute 'src' to 'your-source-here'
        ++i;
    }

    try {
        String strmb = doc.outerHtml();
        bw = new BufferedWriter(new FileWriter(result_doc));
        bw.write(strmb);
        bw.close();
    }
    catch (Exception ex) {
        System.out.println("Program stopped. The problem is " + "\"" +      
     ex.getMessage()+"\"");
    }
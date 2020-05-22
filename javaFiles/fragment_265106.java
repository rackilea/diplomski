Elements div = doc.select("div.div_idalgo_content_result_date_match_local");
    Element firstDiv = div.first();
    Element secondDiv = div.get(1);

    System.out.println("This is the first div: " + firstDiv.text());
    System.out.println("This is the second div: " + secondDiv.text());
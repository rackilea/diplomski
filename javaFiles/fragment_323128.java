for(Element itemlist:temp)
    {
        stmt.setString(1, itemlist.select("h4").text());
        stmt.setString(2, itemlist.select("span.price").text());
        stmt.setString(3, itemlist.select("a").attr("href"));
        stmt.setString(4, itemlist.select("div.ratings").text());
        stmt.addBatch();        
    }        
    stmt.execute();
Elements elh3s = document.select("div.menu-category h3");
for (Element elh3 : elh3s){
    System.out.println("Category: " + elh3.text());

    //get the list by stepping up and then css select the ul
    Elements ellis = elh3.parent().select("ul>li");
    for (Element elli : ellis){
        System.out.println("title: " 
            + elli.select("span.item-title").first().text());
        System.out.println("price: " 
            + elli.select("span.item-price").first().text());
        System.out.println("--");
    }
}
while (card.hasMoreTokens()) {
    String card_type = card.nextToken();
    String card_desc = card.nextToken().replace("\"","");
    //you can call your insert method to insert the data
    // example insert(card_type,card_desc)
    System.out.println(card_type+"::"+card_desc);
}
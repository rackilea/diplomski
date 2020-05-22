String html = "<div id=\"cat-product-list\" alt1=\"356623\" class=\"product-list list_all_items_price price_new\">" +
    "<span id=\"wholesale_11_member_price\" class=\"index-price special_price final_price\" price=\"US$5.25\">" +
    "<strong class=\"final_price_strong\">US$5.25</strong>" +
    "<b class=\"show_vip\">(vip)</b>" +
    "</span>" +
    "<span id=\"wholesale_12_member_price\" class=\"index-price special_price final_price\" price=\"US$4.90\" style=\"display: none\">" +
    "<strong class=\"final_price_strong\">US$4.90</strong>" +
    "<b class=\"show_vip\">(vip)</b>" +
    "</span>" +
    "<span id=\"wholesale_13_member_price\" class=\"index-price special_price final_price\" price=\"US$4.55\" style=\"display: none\">" +
    "<strong class=\"final_price_strong\">US$4.55</strong>" +
    "<b class=\"show_vip\">(vip)</b>" +
    "</span>" +
    "<span id=\"wholesale_14_member_price\" class=\"index-price special_price final_price\" price=\"US$4.20\" style=\"display: none\">" +
    "<strong class=\"final_price_strong\">US$4.20</strong>" +
    "<b class=\"show_vip\">(vip)</b>" +
    "</span>" +
    "<span id=\"shop_price_member_price_on\" class=\"index-price shop_price\" price=\"US$7.00\"><strike>US$7.00</strike></span>" +
    "</div>";

Document doc = Jsoup.parse(html);

// this selector selects the div(s) having classes: "product-list list_all_items_price price_new"
// and within that div, it selects the span(s) having the classes: "index-price special_price final_price"
Elements priceElements = doc.select(
        "div.product-list.list_all_items_price.price_new > span.index-price.special_price.final_price"
);

for (Element priceElement : priceElements) {
    System.out.println(priceElement.attr("price"));
}
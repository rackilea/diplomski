Form<Tenantitem> tenantitemForm = form(Tenantitem.class).bindFromRequest();
Tenantitem tenantItem = tenantitemForm.get(); // bind as Tenantitem object

String[] itemid = request().body().asFormUrlEncoded().get("idd");
String[] postAction = request().body().asFormUrlEncoded().get("action");

if (postAction == null || postAction.length == 0) {
    ... // your code
} else {
    ... // your code
    if ("Add".equals(action)) {
        // declare new variable to store the data submitted
        Tenantitem tenantToBeSaved;

        for (String item: itemid) {
            // asign to an Item object?
            tenantToBeSaved = new Tenantitem();
            Item item_assigned = Tenantitem.findById(item)
            tenantToBeSaved.name = item_assigned.name;
            tenantToBeSaved.description = item_assigned.description;
            tenantToBeSaved.image_url = item_assigned.image_url;
            tenantToBeSaved.price = item_assigned.price;
            tenantToBeSaved.tenant_id = tenantItem.tenant_id;
            tenantToBeSaved.tenant_location_id = tenantItem.tenant_location_id;
            tenantToBeSaved.tenant_page_id = tenantItem.tenant_page_id;

            tenantToBeSaved.save();

            ... // rest of your code
        }
    }   
}
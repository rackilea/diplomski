List<Customer> customerList = CustomerDB.selectAll();

Gson gson = new Gson();
JsonElement element = gson.toJsonTree(customerList, new TypeToken<List<Customer>>() {}.getType());

if (! element.isJsonArray()) {
// fail appropriately
    throw new SomeException();
}

JsonArray jsonArray = element.getAsJsonArray();
String[] parameters = { "addon_domains", "parked_domains", "sub_domains" };

for(String parameter : parameters) {
    for(JsonElement domain : domainsObject.get(parameter).getAsJsonArray()) {
        this.domains.add(domain.getAsString());
    }
}
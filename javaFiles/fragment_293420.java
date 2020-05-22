public class CurrencyDeserializer implements JsonDeserializer<Currency> {
    @Override
    public Currency deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Currency currency = new Currency();

        JsonObject currencyObject = json.getAsJsonObject();

        JsonElement id = currencyObject.get("id");
        if(!id.isJsonNull()) {
            currency.setId(id.getAsInt());
        }

        JsonElement name = currencyObject.get("name");
        if(!name.isJsonNull()) {
            currency.setName(name.getAsString());
        }

        JsonElement symbol = currencyObject.get("symbol");
        if(!symbol.isJsonNull()) {
            currency.setSymbol(symbol.getAsString());
        }

        JsonElement slug = currencyObject.get("website_slug");
        if(!slug.isJsonNull()) {
            currency.setWebsiteSlug(slug.getAsString());
        }

        JsonElement rank = currencyObject.get("rank");
        if(!rank.isJsonNull()) {
            currency.setRank(rank.getAsLong());
        }

        JsonElement circulatingSupply = currencyObject.get("circulating_supply");
        if(!circulatingSupply.isJsonNull()) {
            currency.setCirculatingSupply(circulatingSupply.getAsLong());
        }

        JsonElement totalSupply = currencyObject.get("total_supply");
        if(!totalSupply.isJsonNull()) {
            currency.setTotalSupply(totalSupply.getAsLong());
        }

        JsonElement maxSupply = currencyObject.get("max_supply");
        if(!maxSupply.isJsonNull()) {
            currency.setMaxSupply(maxSupply.getAsLong());
        }

        JsonElement lastUpdated = currencyObject.get("last_updated");
        if(!lastUpdated.isJsonNull()) {
            Long l = lastUpdated.getAsLong() * 1000;
            currency.setLastUpdated(new Date(l));
        }

        JsonObject quotes = currencyObject.get("quotes").getAsJsonObject();

        for(Map.Entry<String, JsonElement> rootObj : quotes.entrySet())
        {
            Quote quote = context.deserialize(rootObj.getValue(), Quote.class);
            quote.setName(rootObj.getKey());
            currency.addQuote(quote);
        }

        return currency;
    }
}
Gson gson = new Gson();

CurrencyData data = new CurrencyData();
data.setBase("USD");
data.setDate("2019-01-01");

Map<String, BigDecimal> ratesMap = new HashMap<>();
ratesMap.put("SEK", new BigDecimal("9.1"));
ratesMap.put("DKK", new BigDecimal("8.2"));
data.setRates(ratesMap);

String json = gson.toJson(data);

System.out.println(json);
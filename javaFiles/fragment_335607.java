// populate map with data mapping key+name to price
Map map = new HashMap();
MultiKey multiKey = new MultiKey(key, name);
map.put(multiKey, price);

// later retireve the price
MultiKey multiKey = new MultiKey(key, name);
<Number> price = (String) map.get(price);
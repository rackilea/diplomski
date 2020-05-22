//does a mapping exist for this specific value?
if(!myMap.containsKey(randomInt)){
    myMap.put(randomInt, new Hashset<Long>());
    myMap.get(randomInt).add(randomLong);
}
//now this value will be defined here.
myMap.get(randomInt).remove(randomLong);
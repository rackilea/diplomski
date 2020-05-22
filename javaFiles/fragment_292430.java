Map<String, NameAndValue> map = new HashMap<>();
for (NameAndValue x : arrayB)
    map.put(x.getName(), x);

for (int i = 0; i < arrayA.size(); i++) 
    arrayB.set(i, map.get(arrayA.get(i).getName()));
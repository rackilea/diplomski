Map<Integer,Integer> map = new HashMap<>();
for(int i: numbers) { //suppose you have the numbers in 'numbers' array
   if(map.containsKey(i) { //this number is in the map already
      map.put(i, map.get(i)+1);
   } else { //we didnt see this number before
      map.put(i, 1);
   }
}

//now we loop the map to sum the repeating numbers
int sum = 0;
for(int amount: map.values()) {
   if(amount > 1) sum += amount;
}
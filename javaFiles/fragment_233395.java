// Using a ArrayList of Integer values as the result
List<Integer> slumptalMindre = new ArrayList<Integer>();

for(int x = 0; x < slumptal.length; x++) {
  if(slumptal[x] < 500)
    slumptalMindre.add(slumptal[x]); 
}
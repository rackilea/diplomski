ArrayList<String> results = new ArrayList<String>;
for(String word : listTwo){
int count = Collections.frequency(list, word);
String result = word +": " count;
results.add(result);
}
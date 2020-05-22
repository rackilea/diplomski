int lengthJSONMerged = JSONmergedJSONDataLog.length();
int count= lengthJSONMerged - 5   // to get start of u

for(u=count;u<lengthJSONMerged;u++)    //lengthJSONMerged to loop upto 7 as arrayindex would be 6
{
  String str = Integer.toString(u);
  JSONArray arrSessionDouble=(JSONArray)JSONmergedJSONDataLog.get(str); //Here loop will run for u=2,3,4,5,6
}
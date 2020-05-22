String[][] countryAndIndustry= {{"au","foo"},{"au","bar"},{"be","baz"}};
Integer[] count= {2,1,2};
HashMap<String,HashMap<String,Integer>> hm=new HashMap<String,    HashMap<String,Integer>>();
for(int i=0;i<count.length;i++)
{
    HashMap<String,Integer> innerMap=hm.get(countryAndIndustry[i][0]);
    if(innerMap==null)
    {
        innerMap=new HashMap<String, Integer>();
        hm.put(countryAndIndustry[i][0],innerMap);
    }
    innerMap.put(countryAndIndustry[i][1],count[i]);
}
// don't use vector, it's ancient and unofficially deprecated
final List<String> keyList = new ArrayList<String>();
final List<String> valueList = new ArrayList<String>();

//...
// add keys and values here


final Map<String, String> map = new HashMap<String, String>();
for(
    Iterator<String> it1 = keyList.iterator(), it2 = valueList.iterator();
    // this works even if the lists have different sizes
    it1.hasNext() && it2.hasNext();){

    map.put(it1.next(), it2.next());

}
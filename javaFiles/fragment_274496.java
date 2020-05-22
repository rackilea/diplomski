fun group(list : List<Income>) : Map<String,List<Income>> {    
    val map = HashMap<String,List<Income>>()
    list.foreach { 
        val month = getMonthOf(it.amountDate)
        if(map.contains(mounth)){
            map[month].add(it);
        } else {
            val arrayList = ArrayList<Income>()
            arrayList.add(it)
            map[month] = arrayList
        }
     }
  return map
}
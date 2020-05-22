ArrayList<HashMap<String, Boolean>> iscompleted = new ArrayList<HashMap<String, Boolean>>();
     for (i=0; i<_listDataHeader.size(); i++) {
         HashMap map = new HashMap<String, Object>();
         for (int j=1; j<_listDataChild.size(); j++){
             map.put(j-1, tasks.get(x).get("isCompleted"));
             x++;
         }
         iscompleted.add(map);
     }
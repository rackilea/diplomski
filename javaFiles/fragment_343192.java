private void returnResults(HttpServletResponse response, String searchQuery) throws IOException{

  //arraylist to hold your Mapped String values.
  ArrayList<Map> arrayOfMap = new ArrayList<Map>(); 
 try{

for (Anime anime : annj.Unmarshalling(searchQuery).getAnn()) {
        Map <String, String> map = new HashMap<String, String>();
        map.put("name", anime.getName());
                map.put("id", anime.getId());

                for (Info temp : anime.getAnime()) {
                    if (temp.getSrc() != null) {

 map.put("url", temp.getSrc());

    }
                }

         //add map to arrayList
         arrayOfMap.add(map);


  }
  //once ready, print all arraylist on response
  response.getWriter().write(new Gson().toJson(arrayOfMap));

  }catch(Exception e){}
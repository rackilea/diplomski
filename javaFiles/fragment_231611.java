if (day.isPresent()){
        return postRepository.findAllByCreateDate(year, month, day);
    } else return postRepository.findAllByMonthAndYear(year, month);

   List<Post> posts = postRepository.findAllByMonthAndYear(year, month);
   Map<Date, List<Post>> postMap = new HashMap();

 if(postMap.contains()){
    //Add record to list for day key
    postMap.put(day,postMap.get(day).add(postObject) ); 
  }else{
     //Add new entry for day
     List<Post> posts = new ArrayList();
     posts.add(postObject);
     postMap.put(day,postMap.get(day).add(posts) );
 }
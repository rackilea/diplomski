@RequestMapping(value="/XXX", method=RequestMethod.GET)
  public List getNextPosts(@RequestParam String next) {
      Query query = new Query();
      query.with(new Sort(Sort.Direction.DESC, "_id"));
      query.limit(5);
      ObjectId objID = new ObjectId(next);
      query.addCriteria(Criteria.where("_id").lt(objID));
      List<Posts> posts = mongoOperation.find(query, Posts.class);
      return posts;
  }
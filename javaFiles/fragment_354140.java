public List<Todo> getUserTodos(String userId)
    Query x = new Query(Criteria.where("_id").is(userId));
    x.fields().exclude("_id").include("todos");
    Map user = mongoTemplate.findOne(x, Map.class);
    if(user != null && user.containsKey("todos")){
      return (List<Todo>)user.get("todos");
    }
    return null;
}
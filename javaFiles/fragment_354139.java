public List<Todo> getUserTodos(String userId)
    Query x = new Query(Criteria.where("_id").is(userId));
    x.fields().exclude("_id").include("todos");
    User user = mongoTemplate.findOne(x, User.class);
    return user.getTodos();
}
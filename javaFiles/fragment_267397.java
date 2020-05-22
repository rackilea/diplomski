2020-01-12 16:15:22.043  INFO 11148 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-01-12 16:15:22.047  INFO 11148 --- [           main] Postman.PostmanApplication               : Started PostmanApplication in 4.602 seconds (JVM running for 5.301)
Aggregation: { "aggregate" : "__collection__", "pipeline" : [{ "$match" : {}}, { "$lookup" : { "from" : "users", "let" : { "postedBy" : "$postedBy"}, "pipeline" : [{ "$match" : { "$expr" : { "$eq" : [{ "$toString" : "$_id"}, "$$postedBy"]}}}], "as" : "user"}}, { "$unwind" : "$user"}, { "$addFields" : { "id" : { "$toString" : "$_id"}, "username" : "$user.name", "upvotes" : { "$size" : "$upvotesBy"}, "isUpvoted" : { "$in" : ["5e18b4c12753608718dfa007", "$upvotesBy"]}, "isPinned" : { "$cond" : [{ "$gte" : [{ "$size" : "$upvotesBy"}, 3]}, true, false]}, "createdAt" : { "$dateToString" : { "format" : "%H:%M %d-%m-%Y", "timezone" : "+01", "date" : "$createdAt"}}}}, { "$sort" : { "isPinned" : -1, "createdAt" : -1}}, { "$project" : { "user" : 0, "_class" : 0}}]}
2020-01-12 16:15:22.161  INFO 11148 --- [           main] org.mongodb.driver.connection            : Opened connection [connectionId{localValue:2, serverValue:277}] to localhost:27017
{
  "username" : "user1",
  "title" : "postim2",
  "description" : "description2",
  "upvotesBy" : [ "5e18b4c12753608718dfa007", "5e19ac0f5161a4994ded1f35" ],
  "file" : "test2",
  "createdAt" : "10:46 12-01-2020",
  "id" : "5e1aeaf8275360bb4bb47325"
}
{
  "username" : "user1",
  "title" : "postim",
  "description" : "description",
  "upvotesBy" : [ "5e18b4c12753608718dfa007", "5e19ac0f5161a4994ded1f35" ],
  "file" : "test",
  "createdAt" : "10:44 12-01-2020",
  "id" : "5e1aea6c275360baf96bac29"
}
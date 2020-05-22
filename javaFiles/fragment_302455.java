status = status.replaceAll("\\(","%28").replaceAll("\\)","%29"); 

client.target("https://api.twitter.com/1.1/statuses/update.json")
.queryParam("status", status)
.request()
...
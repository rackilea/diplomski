params = new StringEntity("{\n" +
"    \"registration_ids\" : [\"ds1YTh...UUZOos\", \"et2ZUi...VVUPpt\"],\n" +
"    \"notification\" : {\n" +
"      \"body\" : \""+jobTitle+"\",\n" +
"      \"title\" : \"New Job!\",\n" +
"      \"icon\" : \"hire\"\n" +
"      \"sound\" : \"default\"\n"+
"       \"time_to_live\" : "+3600+
"    }\n" +
"     \"data\": {"+
"     }"+
" }");
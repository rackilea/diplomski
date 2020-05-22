String myarray = "[{\"name\":\"John\",\"age\":{\"years\":18},\"computer_skills\":{\"years\":4},\"mile_runner\":{\"years\":2}}]";
    JsonArray jsonArray = JsonArray.readFrom(myarray);
    for( JsonValue val : jsonArray) {
        JsonObject myObj = val.asObject();
        for( JsonObject.Member myMember : myObj ) {
            if(myMember.getValue().isObject()) {
                JsonObject myMemberObj = myMember.getValue().asObject();
                for (JsonObject.Member nestedMember : myMemberObj) {
                    if(nestedMember.getName().equals("years")) {
                        myObj.set(myMember.getName(), nestedMember.getValue());
                        break;
                    }
                }
            }
        }
    }
    System.out.println(jsonArray);
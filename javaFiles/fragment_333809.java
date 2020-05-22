public static Person parsePersonJson(String json) {

            JSONObject currentPerson;
            String name;

            try {
                currentPerson = new JSONObject(json);

                // so I can access the name like

                name = currentPerson.getString("name");

                List<String> alsoKnownAs= new ArrayList<>();

                //use getJSONArray to get the list

                JSONArray arrayKnownAs = currentPerson.getJSONArray("alsoKnownAs");

                for (int i = 0, l = arrayKnownAs.length(); i < l; i++) {

                 //This is where I was getting it wrong, i needed to use getString to access list items

                  alsoKnownAs.add(arrayKnownAs.getString(i));
                   }



               Person thisPerson =  new Person(

                //I instantiate person object here

                );
                return thisPerson;

            } catch (org.json.JSONException e) {
             // error
            }
            return null;
        }
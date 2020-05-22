JSONObject obj = new JSONObject(jsonString);
                boolean registered = obj.getBoolean("registered");
                String firstname = obj.getString("firstname");
                String name = obj.getString("name");
                String email = obj.getString("email");
                String picture = obj.getString("picture");
                String username = obj.getString("username");
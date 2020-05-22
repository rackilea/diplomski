for(i = 0; i < location.size(); i++){
                username = location.get(i).get("username").toString();
                name = location.get(i).get("name").toString();
                description = location.get(i).get("description").toString();

                products.add(new Product(username, name, description));
            }
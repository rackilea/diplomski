Entity<String> userEntity = Entity.entity("", MediaType.TEXT_PLAIN);

Response response = target.path("myresource/reduceEnergy/10/action")
                          .request()
                          .put(userEntity);

System.out.println("Status: " + response.getStatus());
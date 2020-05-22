int expected = response.result().bodyAsJsonArray().size();

                Iterator<Object> iterator = response.result().bodyAsJsonArray().iterator();
                while(iterator.hasNext()){
                    Object obj = iterator.next();
                    JsonObject jsonPerson = (JsonObject) obj ;
                    logger.debug("personId: {}", jsonPerson.getString("id"));
                    Person person = new Person();
                    person.setId(jsonPerson.getString("id"));

                    String url2 = wshost+"/persons/"+jsonPerson.getString("id");
                    logger.info("Calling ws to get person details for : {}", jsonPerson.getString("id"), url2);
                    client.getAbs(url2).send(response2 -> {
                        if (response2.succeeded() && response2.result().statusCode()==200) {

                            JsonObject jsonDetails = response2.result().bodyAsJsonObject();
                            person.setDetail(jsonDetails);
                            personList.add(person);
                            logger.info("person is {} ", person);
                            logger.info("iterator.hasNext():{}", iterator.hasNext());

                            // That's the last one
                            if (personList.size() == expected) {
                                // Only now complete the request
                                routingContext.response().setStatusCode(200).end(new JsonArray(personList).toString());
                            }
                        }
                        else{
                            routingContext.response().setStatusCode(500);
                            routingContext.response().end(buildError("Failed to get json ", 600).encode());
                        }

                    });

                };
                logger.info("personList: {} ", personList);
                logger.info("personList size {} ", personList.size());
               // Moved inside callback
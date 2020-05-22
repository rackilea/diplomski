CriteriaBuilder builder = entityManager.getCriteriaBuilder();
CriteriaQuery<Car> query =  builder.createQuery(Car.class);
Root<Car> queryRoot = query.from(Car.class);
query.select(queryRoot);

Path<String> pathToYourField = root.get(yourField); //yourField is a variable containing the field. 
                                                    //You can store all the variables in a list, iterate
                                                    //over them and do this for each one.
query.where(builder.and(builder.equal(pathToYourField, "particularValue"))); //You compare the path against a value.
//Rest of the fields / paths

TypedQuery<Car> typedQuery = entityManager.createQuery(query);
List<Car> cars = typedQuery.getResultList();
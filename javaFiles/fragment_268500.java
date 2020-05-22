org.hibernate.query.Query<Client> q = em.createQuery("select cl, cr " + 
        "from Client cl " + 
        "join CarRent cr on cr.client = cl and cr.carRentKey.dateDue = :date")
        .setParameter("date", exampleDate)
        .unwrap(org.hibernate.query.Query.class).setResultTransformer(new BasicTransformerAdapter() {
            @Override
            public List transformList(List list) {
                Map<Serializable, Client> clientMap =
                        new LinkedHashMap<>(list.size());

                for (Object entityArray: list) {
                    if (Object[].class.isAssignableFrom(entityArray.getClass())) {
                        Client client = null;
                        CarRent carRent = null;

                        Object[] tuples = (Object[]) entityArray;

                        for (Object tuple : tuples) {
                            em.detach(tuple);

                            if (tuple instanceof Client) {
                                client = (Client) tuple;
                            }
                            else if (tuple instanceof CarRent) {
                                carRent = (CarRent) tuple;
                            }
                            else {
                                throw new UnsupportedOperationException(
                                    "Tuple " + tuple.getClass() + " is not supported!"
                                );
                            }
                        }

                        if (client != null) {
                            if (!clientMap.containsKey(client.getId())) {
                                clientMap.put(client.getId(), client);
                                client.setRentHistory(new ArrayList<>());;
                            }
                            if (carRent != null) {
                                client.getRentHistory().add(carRent);
                            }
                        }
                    }
                }
                return new ArrayList<>(clientMap.values());
            }
        });

List<Client> clientList = q.getResultList();
GsonRequest<Person[]> getPersons = 
        new GsonRequest<Person[]>("http://example.com/api/persons/", Person[].class,

            new Listener<Person[]>() {
                @Override
                public void onResponse(Person[] response) {
                    List<Person> persons = Arrays.asList(response);
                    // TODO deal with persons
                }

            }, new ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO deal with error
                }
            });

VolleyQueue.get().add(getPersons);
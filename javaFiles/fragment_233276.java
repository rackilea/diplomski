List<T> clinicalItems = client
        .resource(getBaseUrl() + "/rest/v1/patients/" + subjectKey + "/" + pluralName)
        .accept(MediaType.APPLICATION_JSON_TYPE)
        .get(new GenericType<List<T>>(new ParameterizedType() {
            public Type[] getActualTypeArguments() { return new Type[]{t}; }
            public Type getRawType() { return List.class; }
            public Type getOwnerType() { return null; }
        }));
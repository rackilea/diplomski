public static void main(String[] args) {


        JSONDeserializer<RestApiResponse> js = new JSONDeserializer<RestApiResponse>();


        String input="{\"Target Collection\":[{\"target\":{\"uri\":\"https://opam_server_host:opam_ssl_port/opam/target/9bbcbbb087174ad1900ea691a2573b61\",\"type\":\"ldap\",\"name\":\"person1-ldap\",\"host\":\"opam_server_host\",\"domain\":\"berkeley\",\"description\":\"Ldap target\"}},{\"target\":{\"uri\":\"https://opam_server_host:opam_ssl_port/opam/target/ac246a162ce948c7b1cdcc17dfc92c15\",\"type\":\"ldap\",\"name\":\"person1-ldap2\",\"host\":\"opam_server_host:opam_ssl_port\",\"domain\":\"berkeley\",\"description\":\"Ldap target\"}}]}";

        RestApiResponse restApiResponse=js.deserialize(input,RestApiResponse.class);

        System.out.println(new JSONSerializer()
        .exclude("*.class").deepSerialize(restApiResponse));


    }
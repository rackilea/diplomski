Client client = ClientBuilder.newClient();
WebTarget target = client.target("http://localhost:8080")
                         .path("pmtv2")
                         .path("api")
                         .path("tramitacio")
                         .path("realitzarTramit");

RespostaExpedient response = target.request(MediaType.APPLICATION_JSON)
                                   .post(Entity.json(data)), RespostaExpedient.class);
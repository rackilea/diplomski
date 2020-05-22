HttpClient httpClient = new StdHttpClient.Builder()
                                    .host("[username].cloudant.com")
                                    .port(443)
                                    .username("[username]")
                                    .password("[password]")
                                    .build();
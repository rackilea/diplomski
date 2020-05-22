WS.Response response = WS.url(url)
                    .setHeader("Authorization","BASIC base64str")
                    .setContentType("application/json")
                    .post(requestJsonNode)
                    .get(20000); //20 sec

JsonNode resNode = response.asJson();
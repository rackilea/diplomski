try {

            restTemplate.postForObject(url, pojoInstance, responseClass);

        } catch (HttpStatusCodeException e) {

            if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {

                String responseString = e.getResponseBodyAsString();

                ObjectMapper mapper = new ObjectMapper();

                CustomError result = mapper.readValue(responseString,
                        CustomError.class);
            }
        }
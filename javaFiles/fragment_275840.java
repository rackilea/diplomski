MultiValueMap<String, String> formData = ...
Mono<String> result = webClient.post()
                .uri( "https://emailapi.dynect.net/rest/json/send" )
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .accept( MediaType.APPLICATION_JSON )
                .body( BodyInserters.fromFormData(formData))
                .retrieve().bodyToMono(String.class);
this.client.get().uri("/persons")
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        // The following determines if at least one person is returned with a
        // name containing "oh", and "John" matches that.
        .jsonPath("$[?(@.name =~ /.*oh.*/)].name").hasJsonPath();
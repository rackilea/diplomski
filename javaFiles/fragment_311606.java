testRestTemplate.getRestTemplate().setInterceptors(
        Collections.singletonList((request, body, execution) -> {
            request.getHeaders()
                    .add("header-name", "value");
            return execution.execute(request, body);
        }));
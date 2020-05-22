public Object request(final String url) {
    return restTemplate.getForObject(url, Object.class, parameter);
}

// then invoke like this...
request("https://host?parameter={param}");
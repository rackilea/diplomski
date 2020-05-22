try {
  Object[] mongodata = restTemplate.getForObject(resulturl,Object[].class,keyval);
  list = Arrays.asList(mongodata);
} catch (HttpClientErrorException e) {
  if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
    // Do something
  } else {
    throw e;
  } 
}
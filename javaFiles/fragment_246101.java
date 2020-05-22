import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
...
String restURI = linkTo(methodOn(ServiceB.class).
  shortenerIfReachable(null, null, null, null)).toString();
RestTemplate restTemplate = new RestTemplate();
su = restTemplate.postForObject(restURI, null, ShortURL.class, vars);
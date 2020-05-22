import guru.springframework.domain.Qoate;
// Other imports

@Service
public class service{

@Autowired
private RestTemplate restTemplate;


@Autowired
private ObjectMapper objectMapper;

@Autowired
private QuoteRepository quoteRepository;

public void populateQoats {
// You can chose one of these tow cases

// Case 1
ResponseEntity<List<Qoate>> response = restTemplate.exchange(
  "http://rest to get the list of Qoates",
  HttpMethod.GET,
  null,
  new ParameterizedTypeReference<List<Qoate>>(){});
List<Qoate> result = response.getBody();

// Case 1
String response = restTemplate.getForObject(
  "http://rest to get the list of Qoates",
  String.class);

  List<Qoate> result = objectMapper.readValue(response, new TypeReference<List<Qoate>>(){});

  // Save the list into a database
  if(Objects.nonNull(result)) result.stream().filter(Objects::nonNull).foreach(element -> quoteRepository.saveAndFlush(element));

}

}
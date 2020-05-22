@Autowired
private ObjectMapper objectMapper; // A Jackson ObjectMapper.

@PatchMapping("{id}")
public ResponseEntity<Book> updateAdvisor(
  @PathVariable("id") Integer id, 
  @Valid @RequestBody String newBookJson)
{
  if (isGoodStuff(newBookJson)) // You must write this method.
  {
    final BookDto newBook = ObjectMapper.readValue(newBookJson, BookDto.class);

    ... do stuff.
  }
  else // newBookJson is not good
  {
    .. do error handling stuff.
  }
}
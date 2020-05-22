class MyActor(countryService: CountryService) extends Actor {
  // ...
  val result: Future[Countries] = countryService.getCountries
  result.pipeTo(self)
  // ...
  def recieve = {
    case Countries(c) => // use c
  }
  // ...
}
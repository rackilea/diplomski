@Repository
@Profile("dev")
public abstract class H2HotelRepository implements CrudRepository<Hotel, String>, HotelRepository<Hotel> {
  ...
}
@Repository
@Profile("dev")
public abstract class H2HotelByLetterRepository implements CrudRepository<HotelByLetter, HotelByLetterKey>, HotelByLetterRepository<HotelByLetter, HotelByLetterKey> {
 .....
}
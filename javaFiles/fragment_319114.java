@Repository
@Profile("test")
public class CassandraHotelRepository implements HotelRepository<Hotel> {
....
}

@Repository
@Profile("test")
public class CassandraHotelByLetterRepository implements HotelByLetterRepository<HotelByLetter, HotelByLetterKey> {
 ....
}
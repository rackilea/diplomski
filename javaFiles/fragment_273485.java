@Service("hotelService")
@Transactional
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelDao hotelDao;

    // The rest of code omited ...
}
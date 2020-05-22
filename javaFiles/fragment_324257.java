@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Transactional
    public void update(Integer restaurantId, Restaurant restaurant, User user) {
        Restaurant restaurantToUpdate = restaurantRepository.findById(restaurantId).orElseThrow(()-> new RuntimeException("No restaurant with this ID is found"));

        if(!restaurantToUpdate.getOwnerId().equals(user.getId())){
            throw new RuntimeException("Permission denined as the restaurant the user is not the owner. ")
        }

        //Do your update here such as ......
        restaurantToUpdate.setAddress(restaurant.getAddress());
        .........
    }
}
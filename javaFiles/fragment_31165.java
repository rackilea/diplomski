@Repository
public class ADao {
    @Autowired
    private BDao bdao;//use this to call getB method
    ...
}
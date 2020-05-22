@Service
public class TestService {

    @Autowired
    private RedisTemplate redisTemplate;

    public void saveIt(TestObject testObject){
        ValueOperations<ObjectId, TestObject> values = redisTemplate.opsForValue();
        values.set(testObject.testId, testObject);
    }

}
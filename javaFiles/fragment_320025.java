@Component
public class MyRowMapper implements RowMapper<Map<Integer, Type>> {

   @Autowired
   @Qualifier("myObjectMapper")
   ObjectMapper objectMapper;
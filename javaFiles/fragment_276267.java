@Component
public class Rfid6204Connection{

    @Autowired
    private TagRepository tagRepository;

    public void test(TagReader tag){
        tagRepository.save(tag);
    }

}
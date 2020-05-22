public class SomeC {
    private String p;

    @Autowired
    public SomeC(@Qualifier("p") String p) {
        this. p = p;
    }
}
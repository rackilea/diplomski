@Component
public class Bean1 {

}

@Component
public class Bean2 {
    @Autowired
    public Bean1 bean1;
}
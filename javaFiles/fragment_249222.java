@Component
public class FooComponent {
    @Autowired
    @Qualifier("bonecpDS")
    DataSource boneCPDataSource;
}
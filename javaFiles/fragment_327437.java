@Bean
@Autowired
@Qualifier("messageFeeders")`
public MyClass myClass(List<MessageFeeder> messageFeeders) 
{
    return new MyClass(messageFeeders);`
}
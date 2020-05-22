@Bean
@Autowired
public String aBean(final DataSource  myDS)
{
    return new String("Check myDS properties now");
}
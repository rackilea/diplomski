@Autowired
private MyProcessor processor;

@Override
public void configure() throws Exception
{
    from("file:input")
    .log("from file")
    .processor(processor)
    .to("file:destination")
    .log("to destination")`
    .end();
}
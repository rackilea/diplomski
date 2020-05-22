@Override
public void configure() throws Exception
{
    from("file:input")
    .log("from file")
    .bean("myProcessor")
    .to("file:destination")
    .log("to destination")`
    .end();
}
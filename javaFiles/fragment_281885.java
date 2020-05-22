@Override
public void configure(WebSecurity webSecurity) throws Exception
{
    webSecurity
        .ignoring()
        .antMatchers("/authentication/login**");
}
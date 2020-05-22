@Configuration
public class ServiceConfig{   
   @Bean
   protected UserDAOService daoService()
   {
      return new UserDAOServiceImpl();
   }
   @Bean
   protected UserDetailsService userDetailService( UserDAOService dao )
   {
      return new UserServiceImpl( dao );
   }
   @Bean
   public PasswordEncoder encoder(){
     PasswordEncoder encoder = new CustomPasswordEncoder(); 
     return encoder;
   }
   @Bean
   public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception{                           {
    return new JwtAuthenticationFilter();
   }
}
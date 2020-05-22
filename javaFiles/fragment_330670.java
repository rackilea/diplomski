public class SomeController {

   private AuthenticationModel authenticationModel;

   private LoginService loginService;

   private MyApp view;

   @Listener( event = "login" )
   public void login( LoginEvent event ) {
       view.showWaitDialog();
       loginService.login( event.getUserName(), event.getPassword() )
       .onResult( new Callback<User>() {
           public void onResult( User user ) {
               authenticationModel.setUser( user );
               view.hideWaitDialog();
               view.showStartScreen(user);
           }
       });
   }

}
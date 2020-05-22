public class AndroidLauncher extends AndroidApplication implements IActivityRequestHandler  {

   @Override
   protected void onCreate (Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);

       View gameView=initializeForView(new MyGdxGame(this));
       ....
       ....
   }
public class SportActivity extends AppCompatActivity {
   protected String titleToolbar;

   @Overriden
   public void onCreate(Bundle context) {
      ...
   }
}

public class FootballActivity extends SportActivity {
   @Overriden
   public void onCreate(Bundle context) {
      titleToolbar = "Football";
      super.onCreate(context);
      ...
   }
}
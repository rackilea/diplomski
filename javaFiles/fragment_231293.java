public class HomeActivity extends AppCompatActivity {

    TextView nameuser, walletuser, mainmenus,
            pagetitle, pagesubtitle;

    Button btnguide;
    Animation atg, atgtwo, atgthree;
    ImageView imageView3;
    SharedPreferences sharedpreferences;
    Intent intent;
    private Session session;
    TextView btnLogout, btnDaftarBarang, btnTambah;

    String loggedinusername; //<<<<<<<<<< ADDED
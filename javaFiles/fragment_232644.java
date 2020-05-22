class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbhelper = DatabaseHelper(this)
        dbhelper.insert("TEST001","Just Testing",10,"2019-01-01","2019-01-01")
        dbhelper.logtables()
        dbhelper.update(1,"001TEST")
        dbhelper.logtables()
        dbhelper.delete(1)
        dbhelper.logtables()
    }
}
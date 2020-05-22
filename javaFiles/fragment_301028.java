override fun onCreate(savedInstanceState: Bundle?) {

  if (FirebaseAuth.getInstance().currentUser == null) {
     startActivity(Intent(applicationContext, RegistrationActivity::class.java))
     finish()
     return
  } 

  super.onCreate(savedInstanceState)
  setContentView(R.layout.activity_main)
  // do your other stuff

}
Handler().postDelayed({
    /* Create an Intent that will start the Menu-Activity. */
    val mainIntent = Intent(this, Menu::class.java)
    startActivity(mainIntent)
    finish()
}, 3000)
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this@App)
    }
}
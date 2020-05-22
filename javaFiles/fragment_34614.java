abstract class SteroidsActivity : AppCompatActivity() {

var mInflater: LayoutInflater? = null
abstract fun getActivityLayout(): Int

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    mInflater = layoutInflater?.cloneInContext(this)
    LayoutInflaterCompat.setFactory(mInflater, InflaterOnSteroids(this))
    setContentView(getActivityLayout())
}

override fun getLayoutInflater(): LayoutInflater? {
    return mInflater
}

override fun getSystemService(name: String): Any? {
    if (name == LAYOUT_INFLATER_SERVICE) {
        if (mInflater == null) {
            mInflater = super.getSystemService(name) as LayoutInflater
        }
        return mInflater
    }
    return super.getSystemService(name)
  }
}
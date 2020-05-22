class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val inputXmlString = "<zz>Zhshs<br/>ABC</zz>"
        val inputXmlString = "Aaa<br/><b>Bbb<br/></b>Ccc<br/><ul><li>Ddd</li><li>eee</li></ul>fff<br/><ol><li>ggg</li><li>hhh</li></ol>"

        // XML must have a root tag
        val xmlString = if (!inputXmlString.startsWith("<"))
            "<html>$inputXmlString</html>" else inputXmlString

        val rtApi = RTApi(this, RTProxyImpl(this), RTMediaFactoryImpl(this, true))
        val mRTManager = RTManager(rtApi, savedInstanceState)
        mRTManager.registerEditor(beforeTruncationTextView, true)
        mRTManager.registerEditor(afterTruncationTextView, true)
        beforeTruncationTextView.setRichTextEditing(true, inputXmlString)
        val xmlTag = XmlTag.getXmlFromString(xmlString)

        Log.d("AppLog", "xml parsed: " + xmlTag.toString())
        val maxTextCharacters = 10
        val maxLines = 20

        val output = XmlTagTruncationHelper.truncateXmlTag(xmlTag!!, XmlTagTruncationHelper.Restriction(maxTextCharacters, maxLines))
        afterTruncationTextView.setRichTextEditing(true, output)
        Log.d("AppLog", "xml with truncation : maxTextCharacters: $maxTextCharacters , maxLines: $maxLines output: " + output)
    }
}
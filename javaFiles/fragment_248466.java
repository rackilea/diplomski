typealias Listener = (TestActivity.TestData) -> Unit

class TestActivity {
    private var mListener: Listener? = null

    private fun init() {
        setListener(this::onDataAdded)
    }

    private fun onDataAdded(testData: TestData) {

    }

    fun setListener(listener: Listener) {
        this.mListener = listener
    }

    inner class TestData {
        var data: String? = null
    }
}
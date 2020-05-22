t1.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
    override fun onError(utteranceId: String?) {
    }

    override fun onStart(utteranceId: String?) {
        runOnUiThread {
            recyclerView.adapter?.notifyItemChanged(position)
        }
    }

    override fun onStop(utteranceId: String?, interrupted: Boolean) {
        super.onStop(utteranceId, interrupted)
        onDone(utteranceId)
    }

    override fun onDone(utteranceId: String?) {
        val temp = position
        position = -1
        runOnUiThread {
            recyclerView.adapter?.notifyItemChanged(temp)
        }
    }
}
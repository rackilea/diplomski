override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
     if(resultCode != Activity.RESULT_OK) return
     when(requestCode) {
         324 -> { yourTextView.text = data.getStringExtra("DATE"); }
         // Other result codes
         else -> {}
     }
}
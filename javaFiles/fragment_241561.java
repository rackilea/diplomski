class DialogUtil private constructor() {

init {
throw AssertionError()
}

companion object {

private var progressDialog: ProgressDialog? = null

fun showAlertDialog(context: Context, message: String?) {
    AlertDialog.Builder(context).setMessage(message)
            .setCancelable(false).setPositiveButton("OK") { 
 dialogInterface, _ -> dialogInterface.dismiss() }.show()
}

fun showProgressDialog(context: Context) {
    progressDialog = ProgressDialog(context)
    progressDialog!!.setProgressStyle(ProgressDialog.STYLE_SPINNER)
    progressDialog!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
    progressDialog!!.setMessage("Please wait...")
    progressDialog!!.setCancelable(false)
    progressDialog!!.isIndeterminate = true
    progressDialog!!.show()
}

fun hideProgressDialog() {
    if (progressDialog != null) {
        progressDialog!!.dismiss()
    }
  }
 }
}
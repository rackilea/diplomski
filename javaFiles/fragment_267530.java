val CALL_PERMISSIONS =
        arrayOf(READ_PHONE_STATE, RECORD_AUDIO, WRITE_EXTERNAL_STORAGE)
const val CALL_RECORD_PERMISSION_REQUEST_ALL = 10

class MainActivity : AppCompatActivity() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)  NotificationUtils(this)

val self = this as Context

        val dialog = AlertDialog.Builder(this).apply {
            setTitle(R.string.permissions_required)
            setIcon(R.drawable.ic_done_all_black_24dp)
            setMessage(R.string.grant_permissions_required)

            setPositiveButton("Confirm", { dialog, i ->
                self.batchRequestPermissions(CALL_PERMISSIONS, CALL_RECORD_PERMISSION_REQUEST_ALL)
            })
        }
}
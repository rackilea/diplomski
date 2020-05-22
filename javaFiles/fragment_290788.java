override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.d(TAG, "onCreateDialog called")
        super.onCreateDialog(savedInstanceState)
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(arguments?.getString("aMessage"))
                    .setPositiveButton(arguments?.getString("aPositiveBtnText"), DialogInterface.OnClickListener { dialog, id ->
                        Log.d(TAG, "Yes!")
                        targetFragment?.let { fragment ->
                            fragment.onActivityResult(fragment.targetRequestCode, Activity.RESULT_OK, null)
                        }
                    })
                    .setNegativeButton(arguments?.getString("aNegativeBtnText"), DialogInterface.OnClickListener { dialog, id ->
                        Log.d(TAG, "Dismiss!")
                    })

            Log.d(TAG, "onCreateDialog ending")
            builder.create()
        } ?: throw IllegalStateException("Activity can not be null")
    }
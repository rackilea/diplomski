if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
        val permissionCheck = ContextCompat.checkSelfPermission(applicationContext,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)

        //Granted Permission
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            val sorbetDirectory = File(Environment.getExternalStorageDirectory().path + "/Sorbet")
            sorbetDirectory.mkdirs()
        }

        //Denied Permission
        if (permissionCheck == PackageManager.PERMISSION_DENIED) {
            MaterialDialog.Builder(this)
                    .title(com.marlonjones.sorbet.R.string.titleP)
                    .content(com.marlonjones.sorbet.R.string.perm_content)
                    .positiveText(com.marlonjones.sorbet.R.string.ok)
                    .onPositive { dialog, which ->
                        ActivityCompat.requestPermissions(this@MainActivity,
                                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                                STORAGE_PERMISSION_RC)
                    }
                    .show()
        }

    }
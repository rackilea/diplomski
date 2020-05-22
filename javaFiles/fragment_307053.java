private fun openFile(file: File) {
        val uri = if (Build.VERSION.SDK_INT >= 24) {
            val authority = packageName + ".fileprovider"
            FileProvider.getUriForFile(this, authority, file)
        } else {
            Uri.fromFile(file)
        }

        val myMime = MimeTypeMap.getSingleton()
        val mimeType = myMime.getMimeTypeFromExtension(file.extension)

        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, mimeType)
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

        if (Build.VERSION.SDK_INT >= 26 && !packageManager.canRequestPackageInstalls()) {
            startActivity(
                Intent(
                    Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,
                    Uri.parse("package:$packageName")
                )
            )
        } else {
            intent.action = Intent.ACTION_VIEW
            startActivity(intent)
        }
    }
override fun doInBackground(vararg p0: String?): String { 
 try {
    val inString = ArrayList<String>()
    for (i in 0 until p0.size) {
        val url = URL(p0[i]) 
        val urlConnect = url.openConnection() as HttpURLConnection
        urlConnect.connectTimeout = 7000          
        inString.add(ConvertStreamToString(urlConnect.inputStream)) 
        publishProgress(inString[i])
        try {
            Thread.sleep(500)
        } catch (e: InterruptedException) {}
    }
}catch (e:Exception){}
return " "
}
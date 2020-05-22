onCreate(...){
button1.setOnClickListener {
            val jb = "{......}"
            var rm : String? = null;
            Fuel.post("server_url")
                    .header(Headers.CONTENT_TYPE, "application/json")
                    .body(jb)
                    .response { request, response, result ->
                        Log.d("test", request.toString())
                        Log.d("test", response.toString())
                        val (bytes, error) = result
                        if (bytes != null) {
                            val e = JsonParser().parse(String(bytes))
                            val obj = e.asJsonObject
                            globalRM = obj.get("rm").asString
                            rm = obj.get("rm").asString
                            onFuelFetched(rm)
                        }
                    }
        }
}

fun onFuelFetched(val rm:String?){
    // do anything you wish to do with this value here
}
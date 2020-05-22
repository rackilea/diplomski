String uri = Uri.parse("http://54.174.74.84/api/index/index")
            .buildUpon()
            .appendQueryParameter("data", "{%20%22language_ ..... %22%22%20}")
            .appendQueryParameter("param2", value2)
            .appendQueryParameter("param3", value3)
            .build().toString();
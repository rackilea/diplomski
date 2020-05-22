public fun <T> push(context: Context, url: String, myObject: T,myObjectType : Array<Field>, completion: (response: String) -> Unit) {

    val myObjectAsDict = HashMap<String, String>()
    val allFields = myObjectType //:Array<Field> = myObjectType!!::class.java.declaredFields
    for ( field in allFields) {
        if (!field.isAccessible) {
            field.isAccessible = true
        }


        val value = field.get(myObject)
        if (value != null)
        {
            if( field.name != "serialVersionUID") {
                myObjectAsDict[field.name] = value.toString()
            }
        }
    }

    println(myObjectAsDict)

    val queue = Volley.newRequestQueue(context)
    val sr = object : StringRequest(
        Method.POST, url,
        Response.Listener { response ->
            println(response)
            completion(response)
        },
        Response.ErrorListener { volleyError ->
            Common.showVolleyError(volleyError, context)
        }) {

        override fun getParams(): Map<String, String> {
            val params = myObjectAsDict
            return params
        }

        @Throws(AuthFailureError::class)
        override fun getHeaders(): Map<String, String> {
            val params = HashMap<String, String>()
            params["Content-Type"] = "application/x-www-form-urlencoded"
            params["X-Requested-With"] = "XMLHttpRequest"
            return params
        }
    }

    sr.retryPolicy = DefaultRetryPolicy(
        0,
        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
    )
    queue.add(sr)
}
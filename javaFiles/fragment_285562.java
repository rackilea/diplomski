// Create your request
StringRequest strReq = new StringRequest(Request.Method.POST.......

// Disable the cache option before you add it to the queue.
strReq.setShouldCache(false);

// Adding request to request queue
AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
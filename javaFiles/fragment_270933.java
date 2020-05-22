return Publishers.map(chain?.proceed(request), ::processCookie)

private fun processCookie(a: MutableHttpResponse<*>?) : MutableHttpResponse<*>? {
   print("something something something")
   return a
}
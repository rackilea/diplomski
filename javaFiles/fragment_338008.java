.addOnSuccessListener { bytes ->
    try {
        Log.wtf(TAG, "$name loaded")
        val b = BitmapFactory.decodeByteArray(bytes, 0, bytes.size).scale(ctx.dip(64))
        result = b
    } finally {
        lock.countDown()
    }        
    ctx.saveToCache(name, b)
}
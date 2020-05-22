operator inline fun <reified T : Any> get(key: String, defaultValue: T? = null): T? {
    return when (T::class) {
        String::class -> getString(key, defaultValue as? String) as T?
        java.lang.Integer::class -> getInt(key, defaultValue as? Int ?: -1) as T?
        java.lang.Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as T?
        java.lang.Float::class -> getFloat(key, defaultValue as? Float ?: -1f) as T?
        java.lang.Long::class -> getLong(key, defaultValue as? Long ?: -1) as T?
        else -> throw UnsupportedOperationException("Not yet implemented")
    }
}
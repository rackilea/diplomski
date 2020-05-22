builder.registerTypeAdapter(CharSequence::class.java, object : JsonDeserializer<CharSequence> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): CharSequence = json?.asString ?: ""
})
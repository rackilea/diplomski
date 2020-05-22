class SpecificDeserializer() : StdDeserializer<Specific>(Specific::class.java) {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext): Specific {
        // Deserialize
    }
}

val mapper = jacksonObjectMapper()
mapper.registerModule(SimpleModule().also {
    it.addDeserializer(Specific::class.java, SpecificDeserializer())
})

val foo = mapper.readValue<Foo>(...
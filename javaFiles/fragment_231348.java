...

val gson = GsonBuilder()
    .addDeserializationExclusionStrategy(GsonExclusionStrategy())
    .create()

val rootJsonObject = JsonParser().parse(rootJsonObjectAsString)
val blah = gson.fromJson(rootJsonObject, Blah::class.java)

findAnnotatedFields(
    ExcludeOnDeserialization::class.java,
    Blah::class.java
){ foundExcludedField -> // foundExcludedField = 'myObject' declared in 'Blah' class

    val myObjectAsJsonObject
        = rootJsonObject.asJsonObject.getAsJsonObject(foundExcludedField.name)

    when (foundExcludedField.type) {

        Foo::class.java -> {

            when (blah.type) {

                "A" -> {

                    foundExcludedField.set(
                        blah,
                        gson.fromJson(myObjectAsJsonObject, Bar::class.java)
                    )
                }

                "B" -> {

                    foundExcludedField.set(
                        blah,
                        gson.fromJson(myObjectAsJsonObject, Baz::class.java)
                    )
                }

                else -> return null
            }
        }
    }
}

// The root json object has now fully been mapped into 'blah'
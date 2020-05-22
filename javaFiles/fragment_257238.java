class MovieDeserializer extends JsonDeserializer[Movie] {
    override def deserialize(jp: JsonParser, ctxt: DeserializationContext): Movie {
        val wrapper: JsonNode = jp.getCodec.readValue(jp)
        val id: String = wrapper.get("id").asInstanceOf[TextNode].textValue
        val rawMovie: String = wrapper.get("rawMovieData").textValue

        //Create a new parser to parse the raw json string
        val rawMovieParser: JsonParser = jp.getCodec.getFactory.createParser(rawMovie)
        val movieNode: JsonNode = rawMovieParser.getCodec.readValue(rawMovieParser)
        val name: String = movieNode.get("name").textValue
        val director: String = movieNode.get("director").textValue

        Movie(id, name, director)
    }
}
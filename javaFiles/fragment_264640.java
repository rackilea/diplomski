static String triples =
    "<http://dbpedia.org/resource/53debf646ad3465872522651> <http://dbpedia.org/resource/end> <http://dbpedia.org/resource/1407106906391> ." +
    "\n<http://dbpedia.org/resource/53debf676ad3465872522655> <http://dbpedia.org/resource/foi> <http://dbpedia.org/resource/SpatialThing> .";

public static void main(String[] args) throws IOException {
    Model model = ModelFactory.createDefaultModel()
        .read(IOUtils.toInputStream(triples, "UTF-8"), null, "N-TRIPLES");
    System.out.println("model size: " + model.size());
}
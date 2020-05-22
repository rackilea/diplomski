public class MediaBase {
    private HashMap<Integer, Double> numeros;
    public MediaBase(HashMap<Integer, Double> numeros) {
        this.numeros = numeros;
    }
}

public class FastqcJson {

    @SerializedName("name")
    private String nomeArquivo;
    @SerializedName("data")
    private MediaBase mediaBaseNumeros;

....
}

public class MediaBaseAdapter extends TypeAdapter<MediaBase> {
     @Override
     public MediaBase read(JsonReader reader) throws IOException {
         if (reader.peek() == JsonToken.NULL) {
             reader.nextNull();
             return null;
         }

         HashMap<Integer, Double> output = new HashMap<>();
         reader.beginArray(); //Read "data" as array
         while (reader.hasNext()) {
             reader.beginArray(); //Read data array
             int key = reader.nextInt();
             double value = reader.nextDouble();
             output.put(key, value);
             reader.endArray();
         }
         reader.endArray();
         return new MediaBase(output);
     }

     @Override
     public void write(JsonWriter writer, MediaBase value) throws IOException {
         if (value == null) {
             writer.nullValue();
             return;
         }
         // Inverse of reader
         HashMap<Integer, Double> output = value.numeros;
         writer.beginArray();
         for (Map.Entry<Integer, Double> e : output.entries()) {
             writer.beginArray();
             writer.value(e.getKey());
             writer.value(e.getValue());
             writer.endArray();
         }
         writer.endArray();
     }
}
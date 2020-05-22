Gson gson= new Gson();
Writer output= ... /// wherever you're putting information out to
JsonWriter jsonWriter= new JsonWriter(output);
// jsonWriter.setIndent("\t"); // uncomment this if you want pretty output
// jsonWriter.setSerializeNulls(false); // uncomment this if you want null properties to be emitted
gson.toJson(myObjectInstance, MyObject.class, jsonWriter);
jsonWriter.flush();
jsonWriter.close();
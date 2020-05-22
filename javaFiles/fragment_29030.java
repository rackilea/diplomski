// You can use the same as Row but for clarity I am defining this.

public class ResultEntry implements Serializable {
  //define your df properties ..
}


Dataset<ResultEntry> mappedData = data.mapPartitions(new MapPartitionsFunction<Row, ResultEntry>() {

@Override
public Iterator<ResultEntry> call(Iterator<Row> it) {
  List<ResultEntry> filteredResult = new ArrayList<ResultEntry>();
  while (it.hasNext()) {
   Row row = it.next()
   if(somecondition)
       filteredResult.add(convertToResultEntry(row));
 }
return filteredResult.iterator();
}
}, Encoders.javaSerialization(ResultEntry.class));
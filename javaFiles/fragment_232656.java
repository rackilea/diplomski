org.apache.avro.UnresolvedUnionException: Not in union ["null",{"type":"record","name":"XMLGregorianCalendar","namespace":"javax.xml.datatype","fields":[]}]: 2014-10-22
at org.apache.avro.generic.GenericData.resolveUnion(GenericData.java:604)
at org.apache.avro.generic.GenericDatumWriter.resolveUnion(GenericDatumWriter.java:151)
at org.apache.avro.generic.GenericDatumWriter.write(GenericDatumWriter.java:71)
at org.apache.avro.reflect.ReflectDatumWriter.write(ReflectDatumWriter.java:143)
at org.apache.avro.generic.GenericDatumWriter.writeField(GenericDatumWriter.java:114)
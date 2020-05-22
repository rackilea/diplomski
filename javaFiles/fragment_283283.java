ByteArrayOutputStream backing = new ByteArrayOutputStream();
DataOutput foo = new DataOutputStream(backing); 
// do your serialization out to foo

foo.close();
ByteBuffer buffer = ByteBuffer.wrap(backing.toByteArray());
// now you've got a bytebuffer...
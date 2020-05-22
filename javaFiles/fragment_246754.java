public class PathSerializer implements Serializer<Path> {

@Override
public Serializable toSerializable(Path objectToSerialize) {
    return objectToSerialize.toString();
}

@Override
public Path fromSerializable(Serializable serializedObject) {
    if(!canDeserialize(serializedObject)){
        throw new IllegalArgumentException("Cannot deserialize this");
    }
    return Paths.get((String)serializedObject);
}

@Override
public boolean canDeserialize(Serializable serializedObject) {
    return serializedObject != null && serializedObject instanceof String;
}
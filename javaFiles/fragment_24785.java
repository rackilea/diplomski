public class TagsUtils implements Converter {

public static Set<Tag> getTagsFromString(String tags) {
    Set<Tag> tagSet = new HashSet<>();
    String[] splittedTags = tags.split(",");
    for (String stringTag : splittedTags) {
        stringTag = stringTag.trim();
        Tag tag = new Tag(stringTag);
        tagSet.add(tag);
    }
    return tagSet;
}

@Override
public Class<?> getSourceClass() {
    return String.class;
}

@Override
public Class<?> getTargetClass() {
    return Set.class;
}

@Override
public Object convertSourceToTargetClass(Object o, Class<?> aClass) throws Exception {
    return getTagsFromString((String) o);
}
}
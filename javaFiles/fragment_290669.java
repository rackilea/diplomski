public abstract class ModelList<T> {

        [ paging and caching stuffs ]

        @ForeignCollectionField
        Collection<T> collection;

        [ constructor, getters, setters ]

}
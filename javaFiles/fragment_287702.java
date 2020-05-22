public class Root extends RealmObject {
    private Content Content;
}

public class Content extends RealmObject {
    private RealmList<ContentDetail> ContentDetail;

    @LinkingObjects("Content") 
    private final RealmResults<Root> roots = null;
}

public class ContentDetail extends RealmObject {
    private String FileName;
    private long ContentTypeID;
    //private ContentDetailMetadata ContentDetailMetadata;
    private RealmList<ContentDetailMetadata> ContentDetailMetadata;

    @LinkingObjects("ContentDetail") 
    private final RealmResults<Content> contents = null;
}

public class ContentDetailMetadata extends RealmObject {
    private RealmList<Metadata> Metadata;

    @LinkingObjects("ContentDetailMetadata") 
    private final RealmResults<ContentDetail> contentDetails = null;
}

public class Metadata extends RealmObject {
    private long ID;
    private String Value;

    @LinkingObjects("Metadata") 
    private final RealmResults<ContentDetailMetadata> contentDetailMetadatas = null;
}
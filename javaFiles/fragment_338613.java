@PersistentCapable
class PostTag {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key; 
    /*you should add this to Post and Tag as well,
    since this is what the fields in PostTag will reference
    you can rename them to ClassnameID if you like, I believe*/

    @Persistent
    private Key post;

    @Persistent
    private Key tag;
}
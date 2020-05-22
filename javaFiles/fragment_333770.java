class Chaine { /* empty - enough for testing */ }

class Videos { /* empty - enough for testing */ }


@Root
public class ConfigObject
{
    @Element(name = "pathVideo")
    private PathConfig video;
    @Element(name = "pathBigImage")
    private PathConfig bigImage;
    @Element(name = "pathImage")
    private PathConfig image;
    @Element(name = "pays")
    private String pays;

    // ...
}


@Root
public class PathConfig
{
    @Attribute(name = "extension")
    private String extension;
    @Text
    private String path;

    // ...
}
interface Section extends OptionMap
{
    Section getChild(String key);

    String getName();

    Section getParent();

    String getSimpleName();

    Section addChild(String key);

    String[] childrenNames();

    Section lookup(String... path);

    void removeChild(String key);
}
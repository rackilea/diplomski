@Entry(objectClasses = { "class1", "class2" }, base="ou=my_base_dn")
public final class MyLdapEntity {

    @Id
    private Name dn;

    @Attribute(name="name")
    private String name;

    @Attribute(name="sureName")
    private String sureName;

    @Attribute(name="multiValuedAttr")
    private String[] multiValuedAttr;
}
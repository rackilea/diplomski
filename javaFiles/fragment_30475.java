@XmlRootElement(name = "a")
 public class A {

@XmlElementRefs({
    @XmlElementRef(name = "lang", namespace = "http://www.w3.org/namespace/", type = Lang.class, required = false),
    @XmlElementRef(name = "subst", namespace = "http://www.w3.org/namespace/", type = Subst.class, required = false),
    @XmlElementRef(name = "include", namespace = "http://www.w3.org/namespace/", type = Include.class, required = false),
    @XmlElementRef(name = "br", namespace = "http://www.w3.org/namespace/", type = Br.class, required = false),
    @XmlElementRef(name = "kw", namespace = "http://www.w3.org/namespace/", type = Kw.class, required = false),
    @XmlElementRef(name = "help", namespace = "http://www.w3.org/namespace/", type = Help.class, required = false)
})
@XmlMixed
protected List<Object> content;
@XmlAttribute(name = "cost")
protected String cost;
@XmlAttribute(name = "href", required = true)
protected String href;
@XmlAttribute(name = "key")
protected String key;
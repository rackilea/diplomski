@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractKeywordWithProps
    extends KeywordCommand {

  @XmlAnyElement
  protected final List<Element> allElements = new LinkedList<Element>();

  public AbstractKeywordWithProps() {
  }

  @PostConstruct
  public final void postConstruct() {
    // now, that "allElements" were successfully initialized,
    // do something very important with them ;)
  }

}

// further classes can be derived from this one. postConstruct still works!
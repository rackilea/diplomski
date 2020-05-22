@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "http://www.company.com/catalog3", name = "catalog_titles")
public static class CatalogFeed {
    @XmlElement(namespace = "http://www.company.com/catalog3", name = "catalog_title")
    List<CatalogTitle> catalogTitles;
}
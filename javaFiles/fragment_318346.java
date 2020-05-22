public class Product
{
    public int ID {get; set;}
    public string SKU {get; set;}
    public IList<ProductTranslation> Translations {get; set;}
}
public class ProductTranslation
{
    public string Language {get; set;}
    public bool IsDefaultLanguage {get; set;}
    public string Title {get; set;}
    public string Description {get; set;}
}
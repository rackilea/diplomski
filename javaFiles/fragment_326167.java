Document doc = ...
Elements rows = doc.select("td:containsOwn(contact:)");

for( Element element : rows )
{
    System.out.println(element.text());
}
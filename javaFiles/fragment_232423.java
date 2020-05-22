Field tagName = Tag.class.getDeclaredField("tagName"); // Get the field which contains the tagname
tagName.setAccessible(true); // Set accessible to allow changes

for( Element element : doc.select("*") ) // Iterate over all tags
{
    Tag tag = element.tag(); // Get the tag of the element
    String value = tagName.get(tag).toString(); // Get the value (= name) of the tag

    if( !value.startsWith("#") ) // You can ignore all tags starting with a '#'
    {
        tagName.set(tag, value.toUpperCase()); // Set the tagname to the uppercase
    }
}

tagName.setAccessible(false); // Revert to false
/**
 * This will return all of the documents root fields.
 * 
 * A field might have children that are fields (non-terminal field) or does not
 * have children which are fields (terminal fields).
 * 
 * The fields within an AcroForm are organized in a tree structure. The documents root fields 
 * might either be terminal fields, non-terminal fields or a mixture of both. Non-terminal fields
 * mark branches which contents can be retrieved using {@link PDNonTerminalField#getChildren()}.
 * 
 * @return A list of the documents root fields.
 * 
 */
public List<PDField> getFields()
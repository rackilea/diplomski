/*Create an inner join to the specified Set-valued attribute.
    Parameters:
    attributeName name of the attribute for the target of the join
    Returns:
    the resulting join
    Throws:
    java.lang.IllegalArgumentException if attribute of the given name does not exist*/
182
183    <X, Y> SetJoin<X, Y> More ...joinSet(String attributeName);
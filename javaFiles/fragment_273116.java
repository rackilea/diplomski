/*Create an inner join to the specified single-valued attribute.
    Parameters:
    attribute target of the join
    Returns:
    the resulting join*/
74 
75     <Y> Join<X, Y> More ...join(SingularAttribute<? super X, Y> attribute);
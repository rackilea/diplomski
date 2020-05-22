public boolean equals(Object obj)
{
    if(obj == null) return false;
    if(obj.getClass() != DynamicArrayOfInts.class) return false;

    DynamicArrayOfInts other = (DynamicArrayOfInts) obj;

    /*compare this.storage to other.storage with the iterator
    or with simple indexing.*/
}
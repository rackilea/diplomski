for (int i = 0 , j = 0; i < size ; i++){
     MyObject o = (MyObject)myVector.get (i);
    if (!o.shouldBeDeleted ()){
        //swap the element
        temp = myVector[i]
        myVector[i] = myVector[j]
        myVector[j] = temp;
        j++;
}
}
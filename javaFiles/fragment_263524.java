void * MyVectorCreate()
{
    return new MyVector<int>();
}

void MyVectorAdd(void * vector, int item)
{
    static_cast<MyVector<int> *>(vector)->Add(item);
}

void MyVectorDestroy(void * vector)
{
    delete static_cast<MyVector<int> *>(vector);
}
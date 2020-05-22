public T lastCustomer(int n){
    T result = null;
    while(n > 0){ 
        result = dequeue(); 
        enqueue(result);//you probably don't need to check the result(depends on your implementation)
        n--;
    }
    return result
}
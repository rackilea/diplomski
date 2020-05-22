public T front() throws Exception {

    if(isEmpty()) {
       throw new Exception("Queue is Empty- can't return Front element.");
    }

    return arrayList.get(frontIndex);
}
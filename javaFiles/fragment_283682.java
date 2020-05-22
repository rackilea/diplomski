protected void Person() {
    int results[] = new int[5];
    int index = 0; // index to insert at
     ...
    //getters&setters
    public void setResults(int result) {
        if(index < 5) {
            this.results[index] = result;
            index++;
        }
    }
}
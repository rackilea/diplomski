public LString(String original){ 
    StringBuilder sb = new StringBuilder();
    if (original != ""){
        Scanner darkly = new Scanner(original).useDelimiter("");
        LString currNode = this;
        while (darkly.hasNext()){
            currNode.letter = darkly.next().charAt(0);
            this.length++;
            if (darkly.hasNext()) { //don't add next node if no more chars
                currNode.next = new LString();
                currNode = currNode.next;
            }
        }
    }               
}
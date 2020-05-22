void print() throws IOException{
    BufferedWriter print = new BufferedWriter(new OutputStreamWriter(System.out));
    node temp = this.getFirstNode();
    while(temp != null){
        print.write(temp.getData());
        temp = temp.getNext();
    }
}
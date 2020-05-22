public String toString() {
        BookNode current = front;
        StringBuilder sb = new StringBuilder();
        while (current!=null){
            sb.append(current.getData().toString()+"\r\n ");
            current = current.getNext();
        }
        return sb.toString();
}
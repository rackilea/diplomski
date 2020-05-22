public String toString() {
        String strVal = "";
        for (Node current = head; current != null; current = current.next) {
            strVal = strVal +" "+ current.num;
        }
        return strVal;
    }
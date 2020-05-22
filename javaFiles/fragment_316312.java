if (head.data == x) {
    search = true;
} else {
    while (temp.next != null){
        if (temp.data == x){
            search = true;
            break;
        } else {
            temp = temp.next;
        }
    }
}
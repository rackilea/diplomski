delete = input.nextInt();
if (temp.avr == delete){
    first = temp.next;
}
else{
    while (temp != null && temp.next != null) {
        if (delete == (temp.next.avr)) {
            temp.next = temp.next.next;
            System.out.println("delete this guy");
            break;
        } else {
            temp = temp.next;
        }
    }
}
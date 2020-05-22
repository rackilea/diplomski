public void shift() {
       if (front == null)
            return;
        ListNode oddList, even, odd;
        oddList = even = odd = front;
        oddList = front.next;
        while (even.next != null) {
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            if(odd.next != null) {
                even = odd.next;
                odd.next = null;
            } else {
                odd.next = null;
                break;
            }
        }
        if(oddList != null) {
            even.next = oddList;
        }
        //"front" points to the start of the new list.
   }
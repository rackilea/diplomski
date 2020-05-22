public boolean foo(){
    ListNode current = front;
    ListNode runner = current.next;
    while (runner.next!=null){   //Looks two ahead for the end
        if(current.data!=runner.data){      //They aren't equal, false
            System.out.println(current.data); //just to see my data
            System.out.println(runner.data);  //debugging only
            return false;
        }
        current = current.next.next; //increase by 2
        runner = runner.next.next;   // increase by 2
        System.out.println(current.data + " ||" + runner.data); //again debugging
    }
    if(current.data!=runner.data){      //They aren't equal, false
        System.out.println(current.data); //just to see my data
        System.out.println(runner.data);  //debugging only
        return false;
    }
    return true; // didn't register false, go ahead and true dat badboy.
}
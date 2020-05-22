public class linkedlistcycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head){
        ListNode a = head ;
        ListNode b = head ;


        if ((head == null) || (head.next==null))
        {   return false;}

        while ((head != null) | (head.next != null))
        {

            a = a.next ;
            b = b.next.next;
                    if(a == b)
                        return true;
        } 

    return false ;

        }



    }
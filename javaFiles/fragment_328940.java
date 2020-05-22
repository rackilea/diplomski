for (node<Integer> helper = temp; helper != null && helper.next != null; helper = helper.next)
        {
            //start at helper.next so that temp doesn't delete it's self
            if( temp.data == helper.next.data && helper.next.next != null )
            {
                helper.next = helper.next.next;
            }
            //can't seem to figure out how to delete the tail
            if( temp.data == helper.next.data && helper.next.next == null )
            {
                    helper.next = null;
            }
        }
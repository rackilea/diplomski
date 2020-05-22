//Assume the list is initially of length 1.
for(int i=0;i<searchObject.size();i++) {  //On the first iteration, we check the if condition, and that check passes
//Before we acquire the lock, but after testing the condition, some other thread empties the list
        synchronized (searchObject) {
            if (searchObject.get(i)==what) {
//Whoops, we just called get(0) on a list with no contents - IndexOutOfBoundsException!
                System.out.println(name+": "+what+" => "+true);
            }
        }
    }
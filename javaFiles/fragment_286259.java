private class CustomComparator<T extends Conversation> implements Comparator<Conversation>{
        public int compare(Conversation loBean1, Conversation loBean2) {

    if(obj1.getTime()<obj2.getTime()) {
        return -1;
    } else if(obj1.getTime()>obj2.getTime()) {
        return 1;
    } else {
        return 0
    }
        }
    }

Collections.sort(conversationsList, new CustomComparator<Conversation>());
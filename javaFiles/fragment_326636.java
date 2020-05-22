public class ListSplitter {

    public static void main(String... args) {
        // let's build up the original list
        List<MyObject> oList = new ArrayList<MyObject>();
        for (int i = 0; i < 10; i++) {
            oList.add(new MyObject((long) i, "Hello"));
            oList.add(new MyObject((long) i, "World"));
        }

        // now oList contains 20 items:
        // 2 messages ("Hello" and "World") for each messageFrom field

        // now let's split them up
        Map<Long, ArrayList<String>> data = new HashMap<Long, ArrayList<String>>();
        for (MyObject m : oList) {
            if (!data.containsKey(m.messageFrom)) {
                data.put(m.messageFrom, new ArrayList<String>());
            }
            data.get(m.messageFrom).add(m.message);
        }

        // now you have a map that looks like this:
        //
        // [0] -> "Hello" : "World"
        // [1] -> "Hello" : "World"
        // ...

        // you can now print out the values as such:
        for (Entry<Long, ArrayList<String>> tuple : data.entrySet()) {
            System.out.println("Messages from " + tuple.getKey());
            for (String msg : tuple.getValue()) {
                System.out.println(" -> " + msg);
            }
            System.out.println();
        }
    }

    private static class MyObject implements Comparable<MyObject> {
        public long messageFrom;
        public String message;

        public MyObject(long from, String msg) {
            messageFrom = from;
            message = msg;
        }

        @Override
        public int compareTo(MyObject m) {
            if (messageFrom == m.messageFrom) {
            return message.compareTo(m.message);
            } else {
                return messageFrom - m.messageFrom;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof MyObject)) {
                return false;
            } else {
                return messageFrom == m.messageFrom
                    && message.equals(m.message);
            }
        }

        @Override
        public int hashCode() {
            return messageFrom;
        }
    }
}
Collections.sort(myList, new Comparator<MyData>(){
        @Override
        public int compare(MyData o1, MyData o2) {
            return Long.compare(o1.getTime(), o2.getTime());  
        }
};
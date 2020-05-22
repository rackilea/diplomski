Vector vector = new Vector() {
        @Override
        public synchronized boolean add(Object e) {
            if(!contains(e)){
                return super.add(e);
            }
            System.out.println("Element " + e +" is duplicate");
            return false ;
        }
    };
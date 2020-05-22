Iterator<String> it = result.iterator();
        boolean first = true;

        while(it.hasNext()) {
            if (first) {
                System.out.println("The first element is: "+it.next() );
                first=false;
            } else {
                System.out.println("The next element is: "+it.next() );
            }
        }
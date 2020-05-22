// original array
        List<String> list = Arrays.asList(stringarr);
        // modified array
        List<String> l = new ArrayList<String>();
//      insertion index
        int index = 0;
        for(int i =0 ; i< list.size() ;i++){
            if(!list.get(i).equals(" ") && !list.get(i).equals("")){
                index++;
                //remove extra empty space from end of modified array
                if(l.size() > 1){
                    l.remove(i - index);
                }
            }
            //make sure that first index not empty
            if(i - index == -1 ) {
                index--;
            }
            l.add(i - index, list.get(i));


        }
        System.out.println(Arrays.asList(list));
        System.out.println(Arrays.asList(l));
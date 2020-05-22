for (int i=0;i<list1.size();i++) {
        for (int j=0;j<list2.size(); j++) {
            if(list1.get(i).equals(list2.get(j))){
                System.out.println("equals..:"+list2.get(j));
                newList.add(list2.get(j));
            }
        }
    }
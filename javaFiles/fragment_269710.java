out:
for(int a = 0; a < list1.size(); a++) {
    for(int b = 0; b < list2.size(); b++) {
        for(int c = 0; c < list3.size(); c++) {
            if(list1.get(a) == list2.get(b) && list1.get(a) == list3.get(c) ) {
                System.out.println(list1.get(a));
                break out;
            }
        }
    } 
}
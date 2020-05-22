public static void itarate(List<Part> list,int r){
    for (int i = 0; i<list.size(); i++){
        for(int j=0;j<r;j++)
           System.out.print("  ");
        System.out.println(list.get(i).getDesc() + " x " + list.get(i).getQty());
        if (list.get(i).getListParts() != null){
            itarate(list.get(i).getListParts(),r+1);

        }
    }
public static LinkedPoly add(LinkedPoly list1,LinkedPoly list2){
    LinkedPoly addList=new LinkedPoly();

    Node2 temp1=list1.head;
    Node2 temp3=temp1;
    Node2 temp2=list2.head;
    Node2 temp4=temp2;
    while(temp1.next!=null){
        while(temp2.next!=null){
            if(temp1.exp==temp2.exp){

                addList.createList((temp1.coef+temp2.coef),temp1.exp);
                exponent+=temp1.exp;

            }
            temp2=temp2.next;
        }
        temp1=temp1.next;
        temp2=temp4;
        addList.print();
    }
    String[] array=exponent.split("");


    while(temp3!=null){
        boolean exponentPresent = false;
        for(int i=1;i<array.length;i++){
            if(temp3.exp==Integer.parseInt(array[i])){
                exponentPresent = true;
            }
        }
        if (!exponentPresent) {
            addList.createList(temp3.coef,temp3.exp);
        }
        temp3=temp3.next;
    }
    while(temp4!=null){
        boolean exponentPresent = false;
        for(int i=1;i<array.length;i++){
            if(temp4.exp==Integer.parseInt(array[i])){
                exponentPresent = true;
            }
        }
        if (!exponentPresent) {
            addList.createList(temp4.coef,temp4.exp);
        }
        temp4=temp4.next;
    }


    return addList;
}
for(int[] a_row: a){
    for(int index=0; index < a_row.length; index++){
        a_row[index]+=1;
    }
}

for(int[] a_row: a){
    for(int i: a_row){
        System.out.print(i+"\t");
    }
    System.out.println("\n");
}
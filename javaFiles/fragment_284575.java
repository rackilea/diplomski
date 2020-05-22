public ArrayList<Integer> poli(){

    ArrayList<Integer> policy = new ArrayList<Integer>();

    while(row < 51 ){
        int r = row;
            while(column < 1){

                policy.add(r);
                policy.add(0);

            }

        column-=1;
        row++;
    }

return policy;

}
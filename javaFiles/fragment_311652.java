String[] f = {"One", "Two", "Three","Four","Five"};

    //start at f.length - 1, continue until there is no item left
    for (int i = f.length-1; i >= 0; i--){

        //print current item
        System.out.print(f[i]);

        //if it is not the last item, print separator
        if(i>0){
            System.out.print(", ");
        }
    }
}
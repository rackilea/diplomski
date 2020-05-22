int count = 0;
for(int i=0; i<args.length; i++ ){
    count = 0;
    for (int j = 0; j<args[i].length();j++){
        if (args[i].charAt(j) == 'e'){
        count++;

        }
    }
    System.out.println(count+" ");
}
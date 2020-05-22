Arrays.sort(a);

outerLoop:
for (int i = 0; i < a.length - 2; i++) {

    for(int j = i+1; j < a.length - 1; j++){

        for(int k = j+1; k < a.length; k++){

            if(a[j] - a[i] == a[k] - a[j]){
                System.out.println("yes");
                break outerLoop;
            }

        }

    }

}
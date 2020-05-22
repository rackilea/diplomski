Random generator = new Random();
        ArrayList<Integer> range = new ArrayList<Integer>();
        ArrayList<Integer> generated = new ArrayList<Integer>();

        int x = 10;
        int count = 0;

        for(int i = 0; i<x+1; i++){
            range.add(i);
        }

        while(range.isEmpty() != true){
            int temp = generator.nextInt(x-1);
            count++;
            generated.add(temp);
            if(range.contains(temp)){
                range.removeIf(t -> t == temp);
            }
        }
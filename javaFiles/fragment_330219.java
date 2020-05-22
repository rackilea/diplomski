ArrayList<int> list=new ArrayList<int>();

        for (int j = 1; j < 6; j++){
            int num=stack.pop();
            if(list.contains(num)){
               System.out.println(num);
            }
            else{
                 list.add(num);
            }

        }
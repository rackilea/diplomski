int med=AList.size()-(left.size()+right.size())
            int[] leftArray = new int[left.size()];
            int[] rightArray = new int[right.size()];

        for(int i = 0; i < left.size(); i++){
            leftArray[i] = left.get(i);
        }

        for(int i = 0; i < right.size(); i++){
            rightArray[i] = right.get(i);
        }
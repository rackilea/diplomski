int largeArr[];
    public int[] highest(int y[]){
                if(y!=null)
                {
                    int largest = 500;
                    largeArr[] = new int[y.length];
                    for(int count = 0; count < y.length; count++)
                    {        
                        if(y[count] >= largest){
                            largeArr[count] = y[count];
                            System.out.print(largeArr[count] + " ");  
                        }
                    }
                }
                return largeArr;
            }
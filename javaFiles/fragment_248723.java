int[] array = new int[]{12, 0, -22, 0, 43, 545, -4, -55, 12, 43, 0, -999, -87};
                int counter = 0, 
                temp = 0;//variable that holds the temporary value of each element
                Arrays.sort(array);
                temp=array[0];
                int count=1;
                for(int i=1;i<array.length;i++)
                {
                    //System.out.println(array[i]);
                    if(temp==array[i])
                    {
                        count++;
                    }
                    else
                    {
                        if(count==1)
                        {
                            count=1;

                        }
                        else{
                        System.out.println(array[i-1]+" "+count);
                        count=1;
                        }
                        temp=array[i];
                    }
                }
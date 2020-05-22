if((j==0)||(j==i-1)){
                        // if it is smallest j or biggest j, print 0
                        System.out.print(0);
                    }else if(i == 2*x+1 - 2){
                        // if it is biggest i, print 0
                        System.out.print(0);
                    }
                    else{
                        // the rest conditions, print row number
                        System.out.print((i-1)/2);
                    }
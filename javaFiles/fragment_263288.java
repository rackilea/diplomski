for(int sT = 1 ; sT <= weeks; sT++){
            sum += iA;
            System.out.println("The payable for the week " + sT + " is: " + sum);
            tA = sum;
            if(sT == 1){
                System.out.println("if: " + tA);
                total[sT] = tA;
            }
            else if(sT == 2){
                tA = iA + sum;
                System.out.println("else if: " + tA);
                total[sT] = tA;
            }
            else{
                tA = sum + total[sT - 1];
                System.out.println("else: " + tA);
                total[sT] = tA;
            }
        }
    System.out.println(Arrays.toString(total)); //print stored values of array
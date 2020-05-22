public static byte[] normal(byte[] arr)
    {
        int count = 0;

        for(int i = arr.length-1;i>=0;i--)
        {

            if(arr[i]==1){          
                break;
            }
            count++;
        }

        byte [] output = new byte[copy.length-count];
        for(int i = 0;i<(copy.length-count);i++) {
            output[i] = copy[i];
        }
        return output; 
    }
long high = (raf.length() / 4) - 1 // this is in terms of elements

long mid = (low + high) / 2 ... again element rather than where in byte array

raf.seek(mid * 4)    // You can use the *4 to access the correct location in bytes
cur = raf.readInt()
         if(target < cur){
                high = mid - 1;
            }
            else if(target == cur){
                targetFound = true;
                break;
            }
            else{
                low = mid + 1;
            }
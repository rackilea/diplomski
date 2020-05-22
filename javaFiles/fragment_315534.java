String s = "ababa", key="aba";
    int limit= s.length()-key.length(), count = 0;
    for(int i=0; i<=limit; i++) {
        int index = s.indexOf(key, i);
        if(index!=-1) {
            i=index+1;
            count++;
        }
        else {
            break;
        }
    }
    System.out.println(count);
if(left.size() >= k){
            return QuickSelect(leftArray, k);
        }
        else if(left.size()+med<k){
            return QuickSelect(rightArray, k-(left.size()+med));
        }
        else{
            return a;
        }

    }

    /////////

    public static int medianFind(List<Integer> AList) {
        Collections.sort(AList);
        return AList.get(AList.size() / 2);
    }

    /////////
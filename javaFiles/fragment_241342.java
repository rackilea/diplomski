if(a.compareTo(currentValue.data)<0){               
        currentValue = currentValue.left;
        if(currentValue==null ){
            parent.left = newNode;
            return;
        }
    } else if (a.compareTo(currentValue.data)>0) {
        currentValue = currentValue.right;
        if(currentValue==null){
            parent.right = newNode;
            return;
        }
    } else {
        return; // don't add the a duplicate value
    }
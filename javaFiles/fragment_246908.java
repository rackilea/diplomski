public boolean divide(int depth){
    if(depth <= 0){
        return false;
    }else{
        while(depth > 0) {
            if (!isDivided()) {
                divide();
            } else {
                depth -= 1;
                for (int i = 0; i < 3; i++) {
                    Triangle t=getSubTriangle(i);
                    if (t!=null) {
                      t.divide(depth);
                    }
                }
                depth -= 1;
            }
        }
        return true;
    }

}
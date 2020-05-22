private LinearLayout layoutToggler(LinearLayout[] layoutArr){
        int currentChildCount;
        int minChildCount = MAX_VAL;
        LinearLayout retLayout = null;
        for(LinearLayout layout:layoutArr){
            if((currentChildCount = layout.getChildCount()) == MIN_VAL ){
                retLayout = layout;
                break;
            }
            else if(currentChildCount < minChildCount) {
                retLayout = layout;
                minChildCount = currentChildCount;
            }
        }
        return retLayout;
    }
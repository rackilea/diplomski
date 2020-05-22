public boolean linearIn(int[] outer, int[] inner) {

        for(int x: inner) {
                // assume x is absent.
                boolean result = false;
                for(int y: outer) {
                        // x found in outer.
                        if(x==y) {
                                // make result positive.
                                result = true;
                                // no need to look any further.
                                break;
                        }
                }
                // at this point not all elements of inner are 
                // tested for presence in outer. But one missing ele
                // would mean we return false.
                if(result == false) return false;
        }
        // all ele of inner are present in outer..return true.
        return true;
}
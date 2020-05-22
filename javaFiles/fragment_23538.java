public static Result or(Supplier<Result> r1Supplier, Supplier<Result> r2Supplier) {
        Result r1 = r1Supplier.get();
        if(r1.isTrue()){
            return V(); //new Result with value "True";
        } else if(r1.isUndefined()) {
            return U(); //new Result with value "Undefined";
        }  else {
            // only here you need to handle r2 
            Result r2 = r2Supplier.get();
            if(r2.isTrue()){
                return V(); //new Result with value "True";
            } else if(r2.isUndefined()) {
                return U(); //new Result with value "Undefined";
            }  else {
                return F();
            }
        }
    }
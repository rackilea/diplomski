Consumer<Resource> block = new Consumer<Resource>() {
        @Override
        public void accept(Resource resource) {
            resource.op1().op2();  // there is no return statement
        }
    };
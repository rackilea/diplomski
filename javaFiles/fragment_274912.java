FunctionExecutor processFunction=new FunctionExecutor() {           
            @Override
            public void execute(Params params) {
                Node node = params.getCurrentNode();
                // deserialize to your class
                //YourClass.class=node.toObject(YourClass.class);
                //or
                // directly access data
                System.out.println(node.getData());

            }
        }
Item(...., List< BiFunction<Item, Integer, Integer> > functions, ...)

new Item( ..., Arrays.asList( 
        (i, n) -> {
            return DynamicInfo.getKeyboardX()+i.getObjectWidth()/2;
        },
        (i, n)-> {
            return DynamicInfo.getKeyboardX()+i.getObjectWidth()/2;
        } ), .... );
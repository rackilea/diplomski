.subscribe(new Consumer<Integer>() {

        @Override
        public void accept(Integer color) {
            System.out.println("The color is " + color);
        }
    });
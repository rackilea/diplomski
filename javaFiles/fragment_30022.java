jSpinner1.setModel(new SpinnerNumberModel(1, null, null, 1) {
        @Override
        public Object getNextValue() {                
            Object nextValue = super.getValue();
            int x = Integer.valueOf(nextValue.toString())*2;
            //Object o = x;
            return x;
        }
    });
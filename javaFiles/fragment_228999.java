public boolean canConvert(Class foo) {
            //dont use this converter for the Arraylist. Arraylist will be handeld by the default converter
            if (foo.getName().equals("java.util.ArrayList")) {
                return false;
            }
            return true;
        }
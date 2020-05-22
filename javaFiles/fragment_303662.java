static boolean isDefaultValue(Object obj) {

        if (obj == null // non-primitive
                || obj.equals((byte) 0) // default for byte
                || obj.equals((short) 0) // short
                || obj.equals((int) 0) // int
                || obj.equals(0L) // long
                || obj.equals(0.0f) // float 
                || obj.equals(0.0d) // double
                || obj.equals('\u0000') // char 
                || obj.equals(false)) { // boolean

            return true;
        }
        return false;
    }
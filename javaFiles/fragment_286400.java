public void serializeMethod(Member... member) {
    ObjectOutputStream output = null;
    try {
        output = new ObjectOutputStream(ostream);
        output.writeObject(member);
        //                 ^^^^^^
        // member is an array, because varargs are
        // syntactic sugar for passing an array
        output.close();
    }catch(IOException e) {
        System.out.print("IOException :" + e);
    }
}
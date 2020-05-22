try {
    Class clazz = Class.forName(command);
    InputClazz input = (InputClazz) clazz.newInstance();
    input.execute();
} catch (ClassNotFoundException ex) {    
}
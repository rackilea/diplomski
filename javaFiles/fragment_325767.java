if (ClassB.class.getName().equals(st.getClassName())
                && "methodB".equals(st.getMethodName())) {
    System.out.println("You are allowed to call");
} else {
    throw new IllegalAccessException("You are not allowed to call");
}
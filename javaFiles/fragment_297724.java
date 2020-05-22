public static void main(String[] args) throws Exception {
    xxx();
}

static void xxx() {
    Class[] cc = new SecurityManager() {
        @Override
        protected Class[] getClassContext() {
            return super.getClassContext();
        }
    }.getClassContext();
    System.out.println(cc[cc.length - 1].getName());
}
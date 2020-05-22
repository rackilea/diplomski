class HelperClass {
    public static String doSomething() {
       //some logic
       AnObject obj;
       try {
           obj = Singleton.getInstance().doSomething();
       } catch (Exception1 e) {
           //Some other logic
           throw new Exception2("Some message" + e.getMessage(), e);
       }

       String val = obj.doSomething();
       return val;
    }
}
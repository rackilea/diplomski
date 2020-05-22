InvocationHandler invocationHandler = new InvocationHandler() {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("onMyEvent")) {
                Log.d(TAG, "InvocationHandler.invoke onMyEvent");
                return null;
            }
            else if (String.class == method.getReturnType()) {
                return "";
            }
            else if (Integer.class == method.getReturnType()) {
                return Integer.valueOf(0);
            }
            else if (int.class == method.getReturnType()) {
                return 0;
            }
            else if (Boolean.class == method.getReturnType()) {
                return Boolean.FALSE;
            }
            else if (boolean.class == method.getReturnType()) {
                return false;
            }
            else {
                return null;
            }
        }
    };
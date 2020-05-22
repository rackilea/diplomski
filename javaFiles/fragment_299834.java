Method myMethod;
            try {
                myMethod = TestApp.class.getDeclaredMethod("myMethod", int[].class);
                myMethod.invoke(null, ar);

            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
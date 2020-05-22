TestClass test = new TestClass();
        Field[] fs = test.getClass().getDeclaredFields();
        for (Field field : fs)
        {
            field.setAccessible(true);
            System.out.println( field.getName() + " " + field.get(test) );
        }
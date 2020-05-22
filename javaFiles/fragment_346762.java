Predicate<T> pred = data -> {
        try {
            return ((String) method.invoke(data, (Object[]) null)).equals("foobar");
        } catch (IllegalAccessException illegalAccessException) {
//  
        } catch (IllegalArgumentException illegalArgumentException) {
//
        } catch (InvocationTargetException invocationTargetException) {
//
        }
        return false;
    };
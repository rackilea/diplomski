java.lang.reflect.Method method;
        try {

          method = biometry.getClass().getMethod(methodName, int.class, double.class);
            CalcResult r = (CalcResult) method.invoke(biometry,days, measurement);
            return r;
        } catch (SecurityException e) {
            throw new BiometryException("Security Problem executing " + methodName,e);
        } catch (NoSuchMethodException e) {
            throw new BiometryException("No such method " + methodName,e);
        } catch (IllegalArgumentException e) {
            throw new BiometryException("bad argument for " + methodName,e);
        } catch (IllegalAccessException e) {
            throw new BiometryException("bad access for " + methodName,e);
        } catch (InvocationTargetException e) {
            throw new BiometryException("bad target for " + methodName,e);
        }
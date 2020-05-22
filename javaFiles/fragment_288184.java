for (int i = 0; i < 1000000; i++) {
            Class cls = a.getClass();
            if (cls.isArray() && !cls.getComponentType().isAssignableFrom(Object.class)) {
                int[] b = Arrays.copyOf(a, a.length);
            }
        }
public static Object construct(String s) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
    if (s.matches("^[A-Za-z0-9.#]+\\(.*\\)$")) {
        Class cls = null;
        List<Object> argList = new ArrayList<Object>();
        int parenCount = 0;
        boolean quoted = false;
        boolean escaped = false;
        int argStart = -1;
        for (int i = 0; i < s.length(); i++) {
            if (escaped) {
                escaped = false;
            } else if (s.charAt(i) == '\\') {
                escaped = true;
            } else if (s.charAt(i) == '"') {
                quoted = true;
            } else if (!quoted) {
                if (s.charAt(i) == '(') {
                    if (cls == null)
                        cls = Class.forName(s.substring(0, i));
                    parenCount++;
                    argStart = i + 1;
                } else if (s.charAt(i) == ')') {
                    if (parenCount == 1)
                        argList.add(construct(s.substring(argStart, i)));
                    parenCount--;
                } else if (s.charAt(i) == ',') {
                    if (parenCount == 1) {
                        argList.add(construct(s.substring(argStart, i)));
                        argStart = i + 1;
                    }
                }
            }
        }

        Object[] args = new Object[argList.size()];
        Class[] argTypes = new Class[argList.size()];
        for (int i = 0; i < argList.size(); i++) {
            argTypes[i] = argList.get(i).getClass();
            args[i] = argList.get(i);
        }
        Constructor constructor = cls.getConstructor(argTypes);
        return constructor.newInstance(args);
    } else if (s.matches("^\".*\"$")) {
        return s.substring(1, s.length() - 1);
    } else if (s.matches("^\\d+$")) {
        return Integer.parseInt(s);
    } else {
        throw new RuntimeException("Cannot construct " + s);
    }
}
private static String toStr(Object o) {
    if (o == null || !o.getClass().isArray()) {
        return String.valueOf(o);

    } else {
        final int len = Array.getLength(o);

        StringBuilder sb = new StringBuilder('[');
        for (int i = 0; i < len; i++)
            sb.append(Array.get(o, i)).append(i + 1 < len ? ", " : "");

        return sb.append(']').toString();
    }
}
public static String join(CharSequence delimiter, Iterable<? extends CharSequence> elements) {
    StringBuffer buff = new StringBuffer();

    if (elements != null) {
        Iterator<?> it = elements.iterator();

        if (it.hasNext()) {
            buff.append(it.next());
        }

        while (it.hasNext()) {
            buff.append(delimiter).append(it.next());
        }
    }

    return buff.toString();
}
if (onLine != null) {
    for (String k : onLine.keySet()) {
        for (String v : onLine.get(k)) {
            out.print(v);
        }
    }
}
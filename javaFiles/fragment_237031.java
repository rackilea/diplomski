StringBuilder sb = new StringBuilder();

Iterator<String> iterator = list.iterator();

// First time (no delimiter):
if (iterator.hasNext()) {
    sb.append(iterator.next());

    // Other times (with delimiter):
    while (iterator.hasNext()) {
        sb.append(",");
        sb.append(iterator.next());
    }
}
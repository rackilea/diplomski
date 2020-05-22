for (int i = 0; i < Integer.MAX_VALUE; i++) {
    String value = request.getParameter("name" + i);
    if (value == null) {
        break;
    }
    // Add to list?
}
for (Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
    if (entry.getKey().startsWith("name")) {
        String value = entry.getValue()[0];
        // Add to list?
    }
}
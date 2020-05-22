for (Iterator<String> itIndicsDesc = lTmpIndicsDesc.iterator(); itIndicsDesc.hasNext();) {
    String sTmpIndicsDesc = itIndicsDesc.next();
    for (Iterator<String> itIndicsAvailableMark = lTmpIndicsAvailableMark.iterator(); itIndicsAvailableMark.hasNext();) {
        String sTmpIndicsAvailableMark = itIndicsAvailableMark.next();
        if (sTmpIndicsDesc.toUpperCase().equals(sTmpIndicsAvailableMark.toUpperCase())) {
            itIndicsDesc.remove();
            break; // added
        }
    }
}
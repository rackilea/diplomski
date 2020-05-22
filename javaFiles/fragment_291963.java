for (TreeMap<Integer, Transmitter> current : transmitterDiagnosticMap.values()) {
    for (Map.Entry<Integer, Transmitter> entry : current.entrySet()) {
        Transmitter t = entry.getValue();
        String transmitterError = t.printErrorReport(date, appContext);
        if (transmitterError != null)
            stringsErrorsAndWarnings.add(transmitterError);
        entry.setValue(t);
    }
}
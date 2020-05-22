public static boolean isLineIn(Line.Info lineInfo) {
    Line.Info[] detected = AudioSystem.getSourceLineInfo(Port.Info.LINE_IN);
    for (Line.Info lineIn : detected) {
        if (lineIn.matches(lineInfo)) {
            return true;
        }
    }
    return false;
}
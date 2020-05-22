synchronized (frameList) {
    for (JFrame frame : frameList) {
        if (frame instanceof EditorFrame) ((EditorFrame) frame).close();
        else frame.dispose();
    }
    frameList.clear();
}
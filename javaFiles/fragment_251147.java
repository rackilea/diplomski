class NoteInfomation {
    String inputIDnote;
    String noteDescription;
    public NoteInfomation(String inputIDnote, String noteDescription) {
        this.inputIDnote = inputIDnote;
        this.noteDescription = noteDescription;
    }
    @Override
    public String toString() {
        return "Id:" + inputIDnote + ", Description: " + noteDescription;
    }
}
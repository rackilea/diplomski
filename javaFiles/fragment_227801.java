public class NoteAction extends AbstractAction {
    private Note note;
    private Keys keys;

    public NoteAction(Note note, Keys keys) {
        this.note = note;
        this.keys = keys;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        keys.playNote(note.getValue());
    }

}
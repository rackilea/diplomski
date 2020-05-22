public class PatchedTextField extends JFormattedTextField {

    public PatchedTextField() {
        super();

        final Action originalDeleteAction =
            getActionMap().get(DefaultEditorKit.deletePrevCharAction);

        getActionMap().put(DefaultEditorKit.deletePrevCharAction,
            new AbstractAction() {
                ActionEvent previousEvent;

                public void actionPerformed(ActionEvent e) {
                // Filter out events that happen within 1 millisecond from each other
                if (previousEvent == null || e.getWhen() - previousEvent.getWhen() > 1) {
                    originalDeleteAction.actionPerformed(e);
                }
                previousEvent = e;
            }
        });
    }
}
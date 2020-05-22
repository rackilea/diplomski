public class ArticleSearchDialog extends JDialog {

    public static ArticleId execute(Frame parent) {
        ArticleSearchDialog dialog = new ArticleSearchDialog(parent, true);
        dialog.setVisible(true);
        return dialog.getSelectedArticle();
    }

    private ArticleId getSelectedArticle() {
        return selectedArticle;
    }

    private void jbCancelActionPerformed(ActionEvent evt) {
        selectedArticle = null;
        setVisible(false);
        dispose();
    }

    private void jbOkActionPerformed(ActionEvent evt) {
        selectedArticle = ...; //TODO 
        setVisible(false);
        dispose();
    }        

    // All the rest of the dialog code.
}
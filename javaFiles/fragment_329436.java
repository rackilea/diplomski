import java.awt.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;

public class IterativeDocumentFilter {
    public static void main(String[] arguments) {
        SwingUtilities.invokeLater(
                () -> new IterativeDocumentFilter().createAndShowGui()
        );
    }

    private void createAndShowGui() {
        JFrame frame = new JFrame("Stack Overflow");
        frame.setBounds(100, 100, 1000, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JTextPane textPane = new JTextPane(new DefaultStyledDocument());
        CustomDocumentFilter documentFilter = new CustomDocumentFilter(textPane);
        textPane.setBorder(new LineBorder(Color.BLACK, 1));
        enlargeFont(textPane);

        mainPanel.add(textPane, BorderLayout.CENTER);
        mainPanel.add(createBottomPanels(documentFilter), BorderLayout.PAGE_END);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }

    private JPanel createBottomPanels(CustomDocumentFilter documentFilter) {
        JPanel bottomPanels = new JPanel();
        bottomPanels.setLayout(new BoxLayout(bottomPanels, BoxLayout.PAGE_AXIS));
        for (HighlightGroup highlightGroup : documentFilter.getHighlightGroups()) {
            List<String> textFragments = highlightGroup.getTextFragments();
            JPanel groupPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
            JLabel textFragmentsLabel = new JLabel("Current text fragments: "
                                                   + textFragments);
            textFragmentsLabel.setForeground(highlightGroup.getColor());
            JLabel addTextFragmentLabel = new JLabel("Additional text fragment:");
            addTextFragmentLabel.setForeground(highlightGroup.getColor());
            JTextField addTextFragmentTextField = new JTextField(28);
            JButton addTextFragmentButton = new JButton("Add text fragment");
            addTextFragmentButton.setForeground(highlightGroup.getColor());

            addTextFragmentButton.addActionListener(actionEvent -> {
                String newTextFragment = addTextFragmentTextField.getText().trim();
                if (!textFragments.contains(newTextFragment)) {
                    textFragments.add(newTextFragment);
                    documentFilter.handleTextChanged();
                    textFragmentsLabel.setText("Current text fragments: "
                                               + textFragments);
                }
                addTextFragmentTextField.setText("");
            });

            groupPanel.add(addTextFragmentLabel);
            groupPanel.add(addTextFragmentTextField);
            groupPanel.add(addTextFragmentButton);
            textFragmentsLabel.setBorder(new EmptyBorder(0, 42, 0, 0));
            groupPanel.add(textFragmentsLabel);

            enlargeFont(addTextFragmentLabel);
            enlargeFont(addTextFragmentTextField);
            enlargeFont(addTextFragmentButton);
            enlargeFont(textFragmentsLabel);

            bottomPanels.add(groupPanel);
        }

        return bottomPanels;
    }

    private void enlargeFont(Component component) {
        component.setFont(component.getFont().deriveFont(16f));
    }
}
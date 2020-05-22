package assistance;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class FileDragDemo extends JPanel {

private JList list = new JList();
private JButton btnCompare, btnAnalyze, btnRefresh;

public FileDragDemo() {
    list.setDragEnabled(true);
    list.setTransferHandler(new FileListTransferHandler(list));

    JScrollPane scrollPane = new JScrollPane(list);

    btnCompare = new JButton("Compare");
    btnCompare.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {

        }
    });

    btnAnalyze = new JButton("Analyze");
    btnAnalyze.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {

        }
    });

    btnRefresh = new JButton("Refresh");
    btnRefresh.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            DefaultListModel listModel = (DefaultListModel) list.getModel();
            listModel.removeAllElements();

        }
    });

//      if (listModel.getSize() > 1){
//          btnAnalyze.setEnabled( false );
//      }
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 316, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                            .addComponent(btnRefresh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAnalyze, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCompare, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
    );
    groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
            .addGroup(groupLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(btnCompare)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(btnAnalyze)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(btnRefresh))
    );
    setLayout(groupLayout);
}

private static void createAndShowGui() {
    FileDragDemo mainPanel = new FileDragDemo();

    JFrame frame = new JFrame("FileDragDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(mainPanel);
    frame.pack();
    frame.setLocationByPlatform(true);
    frame.setVisible(true);
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            createAndShowGui();
        }
    });
}

@SuppressWarnings("serial")
class FileListTransferHandler extends TransferHandler {

    private JList list;

    public FileListTransferHandler(JList list) {
        this.list = list;
    }

    public int getSourceActions(JComponent c) {
        return COPY_OR_MOVE;
    }

    public boolean canImport(TransferSupport ts) {
        return ts.isDataFlavorSupported(DataFlavor.javaFileListFlavor);
    }

    public boolean importData(TransferSupport ts) {
        try {
            @SuppressWarnings("rawtypes")
            List data = (List) ts.getTransferable().getTransferData(
                    DataFlavor.javaFileListFlavor);
            if (data.size() < 1) {
                return false;
            }

            DefaultListModel listModel = new DefaultListModel();
            for (Object item : data) {
                File file = (File) item;
                listModel.addElement(file);

            }

            list.setModel(listModel);
            if (list.getModel().getSize() > 1) {
                btnCompare.setEnabled(true);
                btnAnalyze.setEnabled(false);
            } else if (list.getModel().getSize() == 1) {
                btnCompare.setEnabled(false);
                btnAnalyze.setEnabled(true);
            }
            return true;

        } catch (UnsupportedFlavorException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
    }
  }
}
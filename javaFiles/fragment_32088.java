import java.io.*;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Gui
{
    protected Shell shlScrambledata;
    private CCombo  cmbDocType;
    private CCombo  cmbDocModel;
    private Text    txtFile2Read;
    private Text    txtScrambleFile;

    public static void main(String[] args)
    {
        try
        {
            Gui window = new Gui();
            window.open();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void open()
    {
        Display display = Display.getDefault();
        createContents();
        shlScrambledata.open();
        shlScrambledata.pack();
        while (!shlScrambledata.isDisposed())
        {
            if (!display.readAndDispatch())
            {
                display.sleep();
            }
        }
    }

    private void createContents()
    {
        shlScrambledata = new Shell();
        shlScrambledata.setText("ScrambleData");
        shlScrambledata.setLayout(new GridLayout(2, false));

        // Create the document type group
        Group docTypeGroup = new Group(shlScrambledata, SWT.SHADOW_ETCHED_IN);
        docTypeGroup.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));
        docTypeGroup.setLayout(new GridLayout(1, false));
        docTypeGroup.setText("Choose a Document Type");

        cmbDocType = new CCombo(docTypeGroup, SWT.BORDER);
        cmbDocType.setItems(new String[] { "ACC710", "COMKB", "DEB442", "DEB443", "DEB444", "DEB814", "FAC617", "INC411", "INC715", "KLT334 ", "KLT355", "KLT358", "KLT361", "OVK710", "PKOA" });
        cmbDocType.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        // Create the document model group
        Group docModelGroup = new Group(shlScrambledata, SWT.SHADOW_ETCHED_IN);
        docModelGroup.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));
        docModelGroup.setLayout(new GridLayout(1, false));
        docModelGroup.setText("Choose a document model.");

        cmbDocModel = new CCombo(docModelGroup, SWT.BORDER);
        cmbDocModel.setItems(new String[] { "XML", "FlatFile", "COMklantbeeld" });
        cmbDocModel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        // create the file chooser for the fake addresslist
        Group grpSelectTheFake = new Group(shlScrambledata, SWT.SHADOW_ETCHED_IN);
        grpSelectTheFake.setText("Select the fake address list.");
        grpSelectTheFake.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));
        grpSelectTheFake.setLayout(new GridLayout(2, false));

        txtFile2Read = new Text(grpSelectTheFake, SWT.BORDER);
        txtFile2Read.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        Button btnFileChooser = new Button(grpSelectTheFake, SWT.PUSH);
        btnFileChooser.setText("Browse");
        btnFileChooser.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                FileDialog dialog = new FileDialog(shlScrambledata, SWT.NULL);
                String path = dialog.open();

                if (path != null)
                {
                    File file = new File(path);
                    txtFile2Read.setText(file.getAbsolutePath());
                }
            }
        });

        // create the filechooser for the file to be scrambled
        Group grpSelectScrambleFile = new Group(shlScrambledata, SWT.SHADOW_ETCHED_IN);
        grpSelectScrambleFile.setText("Select the file that you want to scramble.");
        grpSelectScrambleFile.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false, 2, 1));
        grpSelectScrambleFile.setLayout(new GridLayout(2, false));

        txtScrambleFile = new Text(grpSelectScrambleFile, SWT.BORDER);
        txtScrambleFile.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        Button btnSelectScrambleFile = new Button(grpSelectScrambleFile, SWT.NONE);
        btnSelectScrambleFile.setText("Browse");

        btnSelectScrambleFile.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                FileDialog dialog = new FileDialog(shlScrambledata, SWT.NULL);
                String path = dialog.open();

                if (path != null)
                {
                    File file = new File(path);
                    txtScrambleFile.setText(file.getAbsolutePath());
                }
            }
        });

        // Create the scramble button
        Button btnScramble = new Button(shlScrambledata, SWT.NONE);
        shlScrambledata.setDefaultButton(btnScramble);
        btnScramble.setText("Scramble!");
        btnScramble.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                System.out.println("DocType: " + cmbDocType.getText());
                System.out.println("DocModel: " + cmbDocModel.getText());
                System.out.println("AddressFile: " + txtFile2Read.getText());
                System.out.println("File2Scramble: " + txtScrambleFile.getText());

            }
        });
    }
}
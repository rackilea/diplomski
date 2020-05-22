import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class MyDemo extends JPanel {
    private static final int GAP = 3;
    private MyPatientTableModel patientModel = new MyPatientTableModel();
    private JTable patientTable = new JTable(patientModel);
    private JTable ptVisitTable = new JTable(new MyPtVisitTableModel(new ArrayList<MyPtVisit>()));

    public MyDemo() {
        MyPatient pt0 = new MyPatient("001", "Johnson", "Michael");
        pt0.addVisit(new MyPtVisit(200, "Head Ache", "Narcotics"));
        pt0.addVisit(new MyPtVisit(300, "Body Ache", "Aspirin"));
        pt0.addVisit(new MyPtVisit(400, "Total Ache", "Nothing"));

        MyPatient pt1 = new MyPatient("002", "Smith", "John");
        pt1.addVisit(new MyPtVisit(220, "Head Ache", "Narcotics"));
        pt1.addVisit(new MyPtVisit(320, "Body Ache", "Aspirin"));
        pt1.addVisit(new MyPtVisit(420, "Total Ache", "Nothing"));

        MyPatient pt2 = new MyPatient("003", "Baker", "Betty");
        pt2.addVisit(new MyPtVisit(240, "Head Ache", "Narcotics"));
        pt2.addVisit(new MyPtVisit(340, "Body Ache", "Aspirin"));
        pt2.addVisit(new MyPtVisit(440, "Total Ache", "Nothing"));

        MyPatient pt3 = new MyPatient("004", "Duck", "Donald");
        pt3.addVisit(new MyPtVisit(260, "Head Ache", "Narcotics"));
        pt3.addVisit(new MyPtVisit(360, "Body Ache", "Aspirin"));
        pt3.addVisit(new MyPtVisit(460, "Total Ache", "Nothing"));

        MyPatient[] pts = { pt0, pt1, pt2, pt3 };

        for (MyPatient myPatient : pts) {
            patientModel.addRow(myPatient);
        }

        patientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        patientTable.getSelectionModel().addListSelectionListener(new PatientTableListener());
        TableColumnModel tcm = patientTable.getColumnModel();
        tcm.removeColumn(tcm.getColumn(3)); // visits column should be invisible

        patientTable.setFillsViewportHeight(true);
        ptVisitTable.setFillsViewportHeight(true);
        Dimension size = patientTable.getPreferredScrollableViewportSize();
        size = new Dimension(size.width, size.height / 2);
        patientTable.setPreferredScrollableViewportSize(size);
        size = ptVisitTable.getPreferredScrollableViewportSize();
        size = new Dimension(size.width, size.height / 2);
        ptVisitTable.setPreferredScrollableViewportSize(size);
        JScrollPane ptTableScrollPane = new JScrollPane(patientTable);
        JScrollPane ptVisitScrollPane = new JScrollPane(ptVisitTable);

        JPanel btnPanel = new JPanel();
        btnPanel.add(new JButton(new SaveChangesAction("Save Changes")));

        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(ptTableScrollPane);
        add(Box.createVerticalStrut(GAP));
        add(ptVisitScrollPane);
        add(Box.createVerticalStrut(GAP));
        add(btnPanel);
    }

    private class SaveChangesAction extends AbstractAction {
        public SaveChangesAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int index = patientTable.getSelectedRow();
            if (index < 0) {
                return;
            }

            // to capture edits not yet complete
            if (ptVisitTable.isEditing()) {
                CellEditor cellEditor = ptVisitTable.getCellEditor();
                if (cellEditor != null) {
                    cellEditor.stopCellEditing();
                }
            }
            index = patientTable.convertRowIndexToModel(index);
            MyPatient selectedPatient = patientModel.getPatient(index);

            MyPtVisitTableModel visitsModel = (MyPtVisitTableModel) ptVisitTable.getModel();
            List<MyPtVisit> visits = visitsModel.getVisits();
            selectedPatient.setVisits(visits);

            patientModel.setPatientAt(index, selectedPatient);
        }
    }

    private class PatientTableListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting()) {
                return;
            }
            int index = patientTable.getSelectedRow();
            if (index < 0) {
                return;
            }
            index = patientTable.convertRowIndexToModel(index);
            MyPatient selectedPatient = patientModel.getPatient(index);
            List<MyPtVisit> visits = selectedPatient.getVisits();
            MyPtVisitTableModel visitsModel = new MyPtVisitTableModel(visits);
            ptVisitTable.setModel(visitsModel);
        }
    }

    private static void createAndShowGui() {
        MyDemo mainPanel = new MyDemo();

        JFrame frame = new JFrame("My Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

@SuppressWarnings("serial")
class MyPatientTableModel extends DefaultTableModel {
    public MyPatientTableModel() {
        super(MyPatient.HEADINGS, 0);
    }

    @SuppressWarnings("unchecked")
    public MyPatient getPatient(int index) {
        String patientId = (String) getValueAt(index, 0);
        String lastName = (String) getValueAt(index, 1);
        String firstName = (String) getValueAt(index, 2);

        // non-displayed data
        List<MyPtVisit> visits = (List<MyPtVisit>) getValueAt(index, 3);
        MyPatient patient = new MyPatient(patientId, lastName, firstName);
        patient.setVisits(visits);
        return patient;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (getRowCount() != 0 && getValueAt(0, columnIndex) != null) {
            return getValueAt(0, columnIndex).getClass();
        } else {
            return super.getColumnClass(columnIndex);
        }
    }

    public void addRow(MyPatient patient) {
        Vector<Object> rowData = new Vector<>();
        rowData.add(patient.getPatientId());
        rowData.add(patient.getLastName());
        rowData.add(patient.getFirstName());
        rowData.add(patient.getVisits()); // not displayed!
        addRow(rowData);

    }

    public void setPatientAt(int row, MyPatient patient) {
        setValueAt(patient.getPatientId(), row, 0);
        setValueAt(patient.getLastName(), row, 1);
        setValueAt(patient.getFirstName(), row, 2);
        setValueAt(patient.getVisits(), row, 3);
    }
}

@SuppressWarnings("serial")
class MyPtVisitTableModel extends DefaultTableModel {
    public MyPtVisitTableModel(List<MyPtVisit> visits) {
        super(MyPtVisit.HEADINGS, 0);
        for (MyPtVisit myPtVisit : visits) {
            addRow(myPtVisit);
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (getRowCount() != 0 && getValueAt(0, columnIndex) != null) {
            return getValueAt(0, columnIndex).getClass();
        } else {
            return super.getColumnClass(columnIndex);
        }
    }

    public void addRow(MyPtVisit myPtVisit) {
        Vector<Object> rowData = new Vector<>();
        rowData.add(myPtVisit.getCost());
        rowData.add(myPtVisit.getSymptom());
        rowData.add(myPtVisit.getTreatment());
        addRow(rowData);
    }

    // extract data from table model
    public List<MyPtVisit> getVisits() {
        List<MyPtVisit> visits = new ArrayList<>();
        for (int i = 0; i < getRowCount(); i++) {
            double cost = (double) getValueAt(i, 0);
            String symptom = (String) getValueAt(i, 1);
            String treatment = (String) getValueAt(i, 2);
            visits.add(new MyPtVisit(cost, symptom, treatment));
        }
        return visits;
    }
}

// class that represents each patient
class MyPatient {
    public static final String[] HEADINGS = { "Patient ID", "Last Name", "First Name", "Visits" };
    private String patientId;
    private String lastName;
    private String firstName;
    private List<MyPtVisit> visits = new ArrayList<>();

    public MyPatient(String patientId, String lastName, String firstName) {
        this.patientId = patientId;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void addVisit(MyPtVisit ptVisit) {
        visits.add(ptVisit);
    }

    public List<MyPtVisit> getVisits() {
        // create new ArrayList to hold copy
        List<MyPtVisit> copyVisits = new ArrayList<>();
        for (MyPtVisit myPtVisit : visits) {
            // use MyPtVisit's copy constructor to create a new MyPtVisit
            copyVisits.add(new MyPtVisit(myPtVisit));
        }
        return copyVisits;
    }

    public void setVisits(List<MyPtVisit> visits) {
        this.visits = visits;
    }

    @Override
    public String toString() {
        return "MyPatient [patientId=" + patientId + ", lastName=" + lastName + ", firstName="
                + firstName + ", visits=" + visits + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((patientId == null) ? 0 : patientId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MyPatient other = (MyPatient) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (patientId == null) {
            if (other.patientId != null)
                return false;
        } else if (!patientId.equals(other.patientId))
            return false;
        return true;
    }

}

// my patient visit
// holds information for each patient's visit to the doctor
class MyPtVisit {
    public static final String[] HEADINGS = { "Cost", "Chief Symptom", "Treatment" };
    private double cost;
    private String symptom;
    private String treatment;

    public MyPtVisit(double cost, String symptom, String treatment) {
        this.cost = cost;
        this.symptom = symptom;
        this.treatment = treatment;
    }

    // copy constructor
    public MyPtVisit(MyPtVisit original) {
        this.cost = original.cost;
        this.symptom = original.symptom;
        this.treatment = original.treatment;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "MyPtVisit [cost=" + cost + ", symptom=" + symptom + ", treatment=" + treatment
                + "]";
    }

}
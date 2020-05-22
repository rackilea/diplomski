import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StudentTablePanel extends JPanel {

    private static JTable table;

    public StudentTablePanel() {
        table = createTable(getStudentList()); // This line—in my opinion—makes it more immediately understandable what is happening, you're creating a table from a list of students.
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        add(scrollPane);
    }

    // Reading "Students.txt" file and adding students to the "studentList" ArrayList.
    public ArrayList<Students> getStudentList() {
        ArrayList<Students> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new URL("http://rawsly.com/Students.txt").openStream())) { // Try with resources loop automatically closes the scanner when done
            while (scanner.hasNext()) {
                String name = scanner.next();
                String lastName = scanner.next();
                long studentId = scanner.nextLong();
                double quiz1 = scanner.nextDouble();
                double quiz2 = scanner.nextDouble();
                double project = scanner.nextDouble();
                double midterm = scanner.nextDouble();
                double finalGrade = scanner.nextDouble();
                double average = scanner.nextDouble();
                String letterGrade = scanner.next();
                list.add(new Students(name, lastName, studentId, quiz1, quiz2, project, midterm, finalGrade, average, letterGrade));
            }
        } catch (IOException ex) {
            // Handle your exception
        }
        return list;
    }

    public JTable createTable(ArrayList<Students> studentList) {
        String[] columnNames = {"NAME", "SURNAME", "ID", "QUIZ1", "QUIZ2", "PROJECT", "MIDTERM", "FINAL", "AVERAGE", "LETTER GRADE"};
        int row = studentList.size();
        int column = columnNames.length;
        Object[][] data = new Object[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                switch (j) {
                    case 0:
                        data[i][0] = studentList.get(i).getName();
                        break;
                    case 1:
                        data[i][1] = studentList.get(i).getLastName();
                        break;
                    case 2:
                        data[i][2] = studentList.get(i).getStudentId();
                        break;
                    case 3:
                        data[i][3] = studentList.get(i).getQuiz1();
                        break;
                    case 4:
                        data[i][4] = studentList.get(i).getQuiz2();
                        break;
                    case 5:
                        data[i][5] = studentList.get(i).getProject();
                        break;
                    case 6:
                        data[i][6] = studentList.get(i).getMidterm();
                        break;
                    case 7:
                        data[i][7] = studentList.get(i).getFinalGrade();
                        break;
                    case 8:
                        data[i][8] = studentList.get(i).getAverage();
                        break;
                    case 9:
                        data[i][9] = studentList.get(i).getLetterGrade();
                } // end of the switch
            } // end of the first for loop
        } // end of the second for loop

        JTable newTable= new JTable(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) { // To make row and columns not editable
                return false;
            }
        };
        newTable.setFillsViewportHeight(true);
        newTable.setAutoCreateRowSorter(true); // to activate sorting property of each column

        return newTable;
    }
}
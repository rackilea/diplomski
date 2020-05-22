import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MemberModel model = new MemberModel();
        StudentsToOutputListener outputListener
                = new StudentsToOutputListener(model, new FileOutput(new File("path to your default file")));
        Window studentDialog = new StudentDialogBox(model);
        Window facilityDialog = new FacultyDialogBox();
        Window memberDialog = new MemberDialogBox(studentDialog, facilityDialog);
        memberDialog.show();
    }
}

class Member {
    private String name;
    private int number;
    private String email;

    public Member(String name, int number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", email='" + email + '\'' +
                '}';
    }
}

interface Window {
    void show();
}

interface Output {
    void output(List<Member> members);
}

interface Listener {
    void update();
}

class MemberDialogBox implements Window {
    private JFrame frame = new JFrame();
    private JComboBox<Window> choiceComboBox = new JComboBox<>();
    private JButton confirmButton = new JButton("Confirm");
    private JLabel selectLabel = new JLabel("Select your ACG Status");

    public MemberDialogBox(Window... windows) {
        for (Window window : windows) {
            choiceComboBox.addItem(window);
        }
        frame();
    }


    public void show() {
        frame.setVisible(true);
    }

    public void frame() {
        frame = new JFrame();
        frame.setSize(210, 150);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(choiceComboBox);
        panel.add(confirmButton);
        panel.add(selectLabel);
        frame.add(panel);

        confirmButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Window window = (Window) choiceComboBox.getSelectedItem();
                window.show();
                frame.dispose();
            }

        });
    }

}

class StudentDialogBox implements Window, Listener, Output {
    private JTextField nameField = new JTextField("", 20);
    private JTextField emailField = new JTextField("", 20);
    private JTextField numberField = new JTextField("", 20);
    private JButton confirmButton = new JButton("Confirm");
    private JButton saveButton = new JButton("Save students to file");
    private JFrame frame;
    private JList<Member> list = new JList<>();
    private MemberModel model;


    public StudentDialogBox(MemberModel model) {
        this.model = model;
        model.addListener(this);
        frame();
    }


    public void show() {
        frame.setVisible(true);
    }


    public void output(List<Member> members) {
        list.setListData(members.toArray(new Member[]{}));
    }


    public void update() {
        model.outputStudentsTo(this);
    }

    public void frame() {
        frame = new JFrame();
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(nameField);
        panel.add(emailField);
        panel.add(numberField);
        panel.add(confirmButton);
        panel.add(list);
        panel.add(saveButton);
        frame.add(panel);

        saveButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showSaveDialog(frame);
                File selectedFile = fileChooser.getSelectedFile();
                Output output = new FileOutput(selectedFile);
                model.outputStudentsTo(output);
            }
        });

        confirmButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String number = numberField.getText();
                String email = emailField.getText();
                Member member = new Member(name, Integer.valueOf(number), email);
                model.addNewStudent(member);
            }
        });

    }


    public String toString() {
        return "Student";
    }
}

class FacultyDialogBox implements Window {

    public void show() {
        System.out.println("you need to implement FacultyDialogBox " +
                "in similar way than StudentDialog box");
    }


    public String toString() {
        return "Faculty/Stuff";
    }
}


class MemberModel {
    private List<Member> students = new ArrayList<>();
    private List<Member> stuff = new ArrayList<>();
    private List<Listener> listeners = new ArrayList<>();

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    private void notifyListeners() {
        for (Listener listener : listeners) {
            listener.update();
        }
    }

    public void addNewStudent(Member member) {
        students.add(member);
        notifyListeners();
    }

    public void addNewStuff(Member member) {
        stuff.add(member);
        notifyListeners();
    }

    public void outputStudentsTo(Output output) {
        output.output(Collections.unmodifiableList(students));
    }

    public void outputStuffTo(Output output) {
        output.output(Collections.unmodifiableList(stuff));
    }
}

class FileOutput implements Output {
    private final File destination;

    public FileOutput(File destination) {
        this.destination = destination;
    }

    public void output(List<Member> members) {
        try (BufferedWriter file = new BufferedWriter(new FileWriter(destination))) {
            for (Member member : members) {
                file.write(member.toString());
                file.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

class StudentsToOutputListener implements Listener {
    private final MemberModel model;
    private final Output output;

    public StudentsToOutputListener(MemberModel model, Output output) {
        this.model = model;
        this.output = output;
        model.addListener(this);
    }

    public void update() {
        model.outputStudentsTo(output);
    }
}
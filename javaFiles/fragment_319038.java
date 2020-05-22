import javax.swing.*;
import java.awt.*;

public final class Example extends JFrame {

    public Example() {

        Course[] courses = {
                new Course("Course 1"),
                new Course("Course 2"),
                new Course("Course 3")
        };

        JList<Course> courseJList = new JList<>(courses);

        getContentPane().add(courseJList);

        pack();
        setMinimumSize(new Dimension(200, 200));
        setVisible(true);
    }

    public static void main(String[] args) {
        new Example();
    }
}

final class Course {

    private final String courseName;

    public Course(final String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return courseName;
    }
}
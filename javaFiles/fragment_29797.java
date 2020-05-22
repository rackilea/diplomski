package com.student.person.work;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sarath_sivan
 */
public class Work {

    public static String calculateGrade() {
        String grade = "";
        // Your code to find the grade.
        //............
        return grade;
    }

    public static void doWork() {
        List<Student> studentList = new ArrayList<Student>();

        Student student = new Student();
        student.setName("ABC");
        student.setAge(24);
        studentList.add(student);

        student = new Student();
        student.setName("DEF");
        student.setAge(28);
        studentList.add(student);

        student = new Student();
        student.setName("GHI");
        student.setAge(21);
        studentList.add(student);

        List<Person> personList = new ArrayList<Person>();

        for(Student students : studentList) {
            Person person = new Person();
            person.setName(students.getName());
            person.setAge(students.getAge());
            person.setGrade(Work.calculateGrade());// Setting the grade
        }
    }

    public static void main(String[] args) {
        Work.doWork();
    }

}
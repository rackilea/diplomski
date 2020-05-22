package com.doc;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class DoctorDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<Doctor> doctors = new ArrayList<Doctor>();

        // populate from database
        // im hard coding
        doctors.add(new Doctor("Test", 1));
        doctors.add(new Doctor("Test2", 2));
        doctors.add(new Doctor("Test3", 3));
        String message = "\n Doctor records \n ";
        for (Doctor doc : doctors) {
            message += "\n\n\n" + "Name:" + doc.getName() + "Id:" + doc.getId();
        }
        JOptionPane.showMessageDialog(null, message);
    }
}
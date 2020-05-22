//Place under your class constructor:
String[] dep = {"Select Depertment","Computer","Civil","Electrical","Telecom"};

String[] semesters={"Select Semester","First Semester","Second Semester","Third Semester",
                    "Fourth Semester","Fifth Semester","Sixth Semester","Seventh Semester"};


String[] firstSemesterBooks = {"Select Book Name","English1;Civil;Telecom","Engineering Drawing;Civil;Electrical",
                               "Mathematics-1;Computer;Civil;Electrical;Telecom","Chemistry;Civil",
                               "Computer Fundamental;Computer;Civil;Electrical;Telecom","Basic Electricity;Electrical",
                               "Basic Electronics;Electrical"};

String[] secondSemesterBooks ={"Select Book Name","English 2;Civil;Telecom","Physical Education;Computer;Civil;Electrical;Telecom",
                               "Physics-1;Civil","Mathematics-2;Computer;Civil;Electrical;Telecom",
                               "Computer Application-1;Computer","Bangla;Telecom","Electronic Device & Circuit-1;Electrical",
                               "Basic Workshop Practice;Civil;Electrical"};

String[] thirdSemesterBooks = {"Select Book Name","Programming Language-1;Computer","Computer Application-2;Computer",
                               "Digital Electronics-1;Electrical", "Industrial Electronics;Electrical","Mathematics-3;Civil;Electrical",
                               "Physics-2;Civil","Social Science-1;Civil"};

String[] fourthSemesterBooks = {"Select Book Name","Programming Language-2;Computer","CAD & Graphics Design;Computer;Civil",
                                "Digital Electronics-2;Electrical", "Data Structure & Algorithm;Computer",
                                "Electrical Circuits & Machine;Electrical","Discrete Mathematics;Civil",
                                "Social Science-2;Civil"};

String[] fifthSemesterBooks = {"Select Book Name","Microprocessor & Microcomputer-1;Computer;Electrical",
                               "Computer Architecture;Computer;Electrical","Programming Language-3;Computer",
                               "Database Management System;Computer","Web Design;Computer","Book Keeping & Accounting;Civil;Telecom",
                               "Environmental Management;Civil"};

String[] sixthSemesterBooks = {"Select Book Name","Microprocessor & Microcomputer-2;Computer;Electrical",
                               "Computer Peripherals;Computer;Electrical", "Data Comm. & Computer Network-1;Computer",
                               "Computer System Software;Computer","Computer Servicing;Computer;Electrical",
                               "Web Development;Computer","Business Org. & Communication;Civil"};

String[] seventhSemesterBooks = {"Select Book Name","Embedded Systems & PLC;Electrical","Multimedia & Graphics;Computer",
                                 "System Analysis & Design;Computer;Civil","Data Comm. & Computer Network-2;Computer",
                                 "Computer Engineer Project;Computer","Industrial Management;Civil;Telecom",
                                 "Entrepreneurship;Computer;Civil;Electrical;Telecom"};   

// *******************************************************
// * I have added the Departements to Book Titles. It's up to YOU to make *
// * sure they are correct!                                                                 *
// *******************************************************


// JButton used to load up the Department ComboBox
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    divcomboDepartment.removeAllItems();
    divcomboSemester.removeAllItems();
    divcomboBook.removeAllItems();
    divcomboSemester.setEnabled(false);
    divcomboBook.setEnabled(false);

    for(int i=0; i< dep.length; i++) {
       divcomboDepartment.addItem(dep[i]);
    }  

}  

private void divcomboDepartmentItemStateChanged(java.awt.event.ItemEvent evt) {
    divcomboSemester.removeAllItems();
    divcomboBook.removeAllItems();

    if(divcomboDepartment.getSelectedIndex() == 0) {
        divcomboSemester.setEnabled(false);
        divcomboBook.setEnabled(false);
        return;
    }
    String depName = divcomboDepartment.getSelectedItem().toString();
    for(int i=0; i< semesters.length;i++) {
        divcomboSemester.addItem(semesters[i]);
    }
    divcomboSemester.setEnabled(true);
}

private void divcomboSemesterItemStateChanged(java.awt.event.ItemEvent evt) {
    divcomboBook.removeAllItems();
    String department = divcomboDepartment.getSelectedItem().toString();

    if(divcomboSemester.getSelectedIndex() == 0) {
        divcomboBook.setEnabled(false);
        return;
    }
    String[] semesterBooks = null;
    String semesterStrg = evt.getItem().toString(); 
    if (semesterStrg.equalsIgnoreCase("first semester")) { semesterBooks = firstSemesterBooks; }
    else if (semesterStrg.equalsIgnoreCase("second semester")) { semesterBooks = secondSemesterBooks; }
    else if (semesterStrg.equalsIgnoreCase("third semester")) { semesterBooks = thirdSemesterBooks; }
    else if (semesterStrg.equalsIgnoreCase("fourth semester")) { semesterBooks = fourthSemesterBooks; }
    else if (semesterStrg.equalsIgnoreCase("fifth semester")) { semesterBooks = fifthSemesterBooks; }
    else if (semesterStrg.equalsIgnoreCase("sixth semester")) { semesterBooks = sixthSemesterBooks; }
    else if (semesterStrg.equalsIgnoreCase("seventh semester")) { semesterBooks = seventhSemesterBooks; } 
    else { return; }

    addBooksToComboBox(divcomboBook, semesterBooks, department);
    divcomboBook.setEnabled(true);
}

private static void addBooksToComboBox(final JComboBox combo, final String[] semesterArray, final String department) {
    for(int i = 0; i < semesterArray.length; i++) {
        String booksStrg = semesterArray[i];
        if (booksStrg.contains(";")) {
            String[] depts = booksStrg.split(";");
            for (int j = 0; j < depts.length; j++) {
                if (depts[j].equalsIgnoreCase(department)) {
                    combo.addItem(depts[0]);
                }
            }
        }
        else { combo.addItem(booksStrg); }
    }
}
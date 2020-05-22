} else if (m.equals("7")) {
        JOptionPane.showMessageDialog(null,
              "Output information to a .txt file");
        final PrintWriter out = new PrintWriter(outputFileName);
        out.println("The students' information is listed below:");
        for (Student Stu : student) {
           out.println(Stu.getId() + " " + Stu.getLName() + " "
                 + Stu.getGpa());
        }
        out.close();
     }
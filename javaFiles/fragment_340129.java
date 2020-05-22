if (jComboBox2.getSelectedItem() == null) { //port is not selected
   System.out.println("Port is not selected");
} else { //port is selected. 
   try {
        Runtime r = Runtime.getRuntime();

        p = Runtime.getRuntime().exec("C:\\Program Files\\Scratch 2\\Scratch 2.exe C:\\Program Files\\Robotix\\fwdbckpwm12.sb2");


        A4S a4sObj = new A4S(new String[]{jComboBox2.getSelectedItem().toString()}); 


    } catch (IOException ex) {
       Logger.getLogger(serialportselection.class.getName()).log(Level.SEVERE, null, ex);
    }
}
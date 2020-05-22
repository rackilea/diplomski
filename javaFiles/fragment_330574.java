package test;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class TestDateFormat {

    public static void main(String[] args) {
        SimpleDateFormat MydateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String fdate = MydateFormat.format(date);
        System.out.println(date + " \tFORMATTED: " + fdate);
        JOptionPane.showMessageDialog(null, fdate);
    }
}
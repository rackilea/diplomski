import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalTime;
import javax.swing.*;

public class Clock {
    public static void main(String... arg) {
        EventQueue.invokeLater(Clock::openGUI);
    }
    static void openGUI()
    {
        try{ UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch(Exception ex){}// not mandatory
        JFrame frame=new JFrame("Clock");
        JLabel l1=new JLabel(), l2=new JLabel();
        ActionListener updater=ev->{
            LocalTime morning = LocalTime.of(05, 00);
            LocalTime evening = LocalTime.of(17, 00);
            LocalTime time = LocalTime.now();
            Duration fromMorning = Duration.between(morning, time);
            Duration toEvening = Duration.between(evening, time);
            if(fromMorning.isNegative()) toEvening=toEvening.plusDays(1);
            else if(!toEvening.isNegative()) fromMorning=fromMorning.minusDays(1);
            l1.setText(format(fromMorning, "morning"));
            l2.setText(format(toEvening, "evening"));
        };
        updater.actionPerformed(null);
        frame.getContentPane().add(l1, BorderLayout.NORTH);
        frame.getContentPane().add(l2, BorderLayout.SOUTH);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        new Timer(1000, updater).start();
    }
    private static String format(Duration d, String event) {
        long s=d.getSeconds();
        String prep=" since ";
        if(s<0) { s=-s; prep=" to "; }
        long h=s/3600, min=s/60;
        s-=min*60; min-=h*60;
        return h+" hour(s), "+min+" min, "+s+" sec"+prep+event;
    }
}
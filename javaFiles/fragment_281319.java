package pack;

import java.awt.Dimension;
import java.text.NumberFormat;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import crea.AdditionTest;

public class Main extends RunListener
{
    private final JTextArea textArea    = new JTextArea();
    private final String    results     = new String();

    public static void main(String[] args)
    {
        new Main();
    }

    public Main()
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JScrollPane jScrollPane = new JScrollPane(textArea);
                jScrollPane.setPreferredSize(new Dimension(500, 500));

                JFrame frame = new JFrame("Addition Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(jScrollPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });

        JUnitCore runner = new JUnitCore();
        runner.addListener(this);
        runner.run(AdditionTest.class);
    }

    @Override
    public void testFinished(Description description) throws Exception
    {
        super.testFinished(description);

        textArea.setText(results);
    }

    @Override
    public void testRunFinished(Result result)
    {
        printHeader(result.getRunTime());
        printFailures(result);
        printFooter(result);
    }

    @Override
    public void testStarted(Description description)
    {
        textArea.append(".");
    }

    @Override
    public void testFailure(Failure failure)
    {
        textArea.append("E");
    }

    @Override
    public void testIgnored(Description description)
    {
        textArea.append("I");
    }

    protected void printHeader(long runTime)
    {
        textArea.append("\n");
        textArea.append("Time: " + elapsedTimeAsString(runTime) + "\n");
    }

    protected void printFailures(Result result)
    {
        List<Failure> failures = result.getFailures();
        if (failures.size() == 0)
            return;
        if (failures.size() == 1)
            textArea.append("There was " + failures.size() + " failure:" + "\n");
        else
            textArea.append("There were " + failures.size() + " failures:"
                    + "\n");
        int i = 1;
        for (Failure each : failures)
            printFailure(each, "" + i++);
    }

    protected void printFailure(Failure each, String prefix)
    {
        textArea.append(prefix + ") " + each.getTestHeader() + "\n");
        textArea.append(each.getTrace());
    }

    protected void printFooter(Result result)
    {
        if (result.wasSuccessful())
        {
            textArea.append("\n");
            textArea.append("OK");
            textArea.append(" (" + result.getRunCount() + " test"
                    + (result.getRunCount() == 1 ? "" : "s") + ")" + "\n");

        }
        else
        {
            textArea.append("\n");
            textArea.append("FAILURES!!!");
            textArea.append("Tests run: " + result.getRunCount()
                    + ",  Failures: " + result.getFailureCount() + "\n");
        }
        textArea.append("\n");
    }

    protected String elapsedTimeAsString(long runTime)
    {
        return NumberFormat.getInstance().format((double) runTime / 1000);
    }
}
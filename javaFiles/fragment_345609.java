import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.kernel.impl.util.FileUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Frame extends JFrame {

    public static final String DB_PATH = "/Volumes/iTanioHD/Users/tanio/Desktop/ciao";

    private static GraphDatabaseService db;

    private JPanel contentPane;


    public static void main(String[] args) {
        db = new GraphDatabaseFactory().newEmbeddedDatabase(DB_PATH);
        registerShutdownHook(db);

        Transaction tx = db.beginTx();
        try {
            db.getNodeById(0).setProperty("name", "Name 0");
            db.createNode().setProperty("name", "Name 1");
            db.createNode().setProperty("name", "Name 2");
            tx.success();
        } finally {
            tx.finish();
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Frame frame = new Frame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void registerShutdownHook(final GraphDatabaseService graphDb) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                graphDb.shutdown();
                try {
                    FileUtils.deleteRecursively(new File(DB_PATH));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public Frame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 794, 653);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);


        final JTextArea queryTextArea = new JTextArea();
        queryTextArea.setBounds(25, 40, 702, 279);
        queryTextArea.setBorder(new EmptyBorder(5, 5, 5, 5));
        queryTextArea.setText("start n=node(*) return n, n.name");
        contentPane.add(queryTextArea);

        JLabel cypherQueryLabel = new JLabel("Cypher Query");
        cypherQueryLabel.setBounds(25, 12, 105, 23);
        contentPane.add(cypherQueryLabel);

        final JTextArea resultTextArea = new JTextArea();
        resultTextArea.setBounds(25, 351, 702, 171);
        resultTextArea.setEditable(false);
        resultTextArea.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.add(resultTextArea);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(25, 323, 55, 23);

        contentPane.add(resultLabel);

        JButton btnNewButton_2 = new JButton("Execute Query");
        btnNewButton_2.setBounds(274, 540, 176, 41);
        btnNewButton_2.setVisible(true);
        contentPane.add(btnNewButton_2);

        btnNewButton_2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ExecutionEngine engine = new ExecutionEngine(db);
                ExecutionResult result = engine.execute(queryTextArea.getText());
                resultTextArea.setText(result.dumpToString());
            }
        });
    }
}
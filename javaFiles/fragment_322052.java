import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class Translator {
    private static final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
    private static final String CLIENT_SECRET = "PUBLIC_SECRET";
    private static final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";

    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) throws Exception {
        Translator g = new Translator();

        JFrame f = new JFrame();//creating instance of JFrame  
        f.setTitle("Translator");
        f.setAlwaysOnTop(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setPreferredSize(new Dimension(295, 300));
        f.setLayout(null);  //using no layout manager (*** BAD IDEA!! ***)

        String[] transDirection = {"English To Spanish", "Spanish To English"};        
        JComboBox<String> jc = new JComboBox<>(transDirection);
        jc.setSelectedIndex(0);
        jc.setBounds(60, 30, 160, 25);
        f.add(jc);

        JButton b = new JButton("Translate");//creating instance of JButton  
        b.setBounds(90, 140, 100, 30);//x axis, y axis, width, height  
        f.add(b);//adding button in JFrame  

        Border border = BorderFactory.createLineBorder(Color.decode("#33acff"));
        JTextArea t1 = new JTextArea(2, 2);
        t1.setBounds(40, 80, 200, 50);
        t1.setBorder(border);
        t1.setLineWrap(true);
        t1.setWrapStyleWord(true);
        JScrollPane sp1 = new JScrollPane(t1);
        sp1.setBounds(40, 80, 200, 50);
        // ---------------------
        JTextArea t2 = new JTextArea(2, 2);
        t2.setBounds(40, 180, 200, 50);
        t2.setBorder(border);
        t2.setLineWrap(true);
        t2.setWrapStyleWord(true);
        JScrollPane sp2 = new JScrollPane(t2);
        sp2.setBounds(40, 180, 200, 50);
        f.add(sp1, BorderLayout.CENTER);
        f.add(sp2, BorderLayout.CENTER);

        f.pack();
        f.setVisible(true);//making the frame visible  
        f.setLocationRelativeTo(null); // Must be after setVisible().

        t1.requestFocus(); // Set focus on t1 when started

        // Button Action Listener...
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String text = t1.getText().trim();

                //Make sure there is text to translate...
                if (text.equals("")) {
                    JOptionPane.showMessageDialog(f, "There is no text supplied to translate!", 
                                                  "Translation Error!", JOptionPane.WARNING_MESSAGE);
                    return;     // Get out of this event.
                }
                // Get selected language translation direction...
                String fromLang = "";
                String toLang = "";                
                switch (jc.getSelectedItem().toString().toLowerCase()) {
                    case "english to spanish":
                        fromLang = "en";
                        toLang = "es";
                        break;
                    case "spanish to english":
                        fromLang = "es";
                        toLang = "en";
                        break;
                    default:
                        fromLang = "en";
                        toLang = "es";
                }

                try {
                    String translation = translate(fromLang, toLang, text);
                    t2.setText(translation);
                }
                catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

    /**
     * Sends out a WhatsApp message via WhatsMate WA Gateway.<br><br>
     * @param fromLang
     * @param toLang
     * @param text
     * @return 
     * @throws java.lang.Exception
     */
    public static String translate(String fromLang, String toLang, String text) throws Exception {
        // TODO: Should have used a 3rd party library to make a JSON string from an object
        String jsonPayload = new StringBuilder()
                .append("{")
                .append("\"fromLang\":\"")
                .append(fromLang)
                .append("\",")
                .append("\"toLang\":\"")
                .append(toLang)
                .append("\",")
                .append("\"text\":\"")
                .append(text)
                .append("\"")
                .append("}")
                .toString();

        URL url = new URL(ENDPOINT);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
        conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
        conn.setRequestProperty("Content-Type", "application/json");

        // 'Try With Resources' used here to auto-close stream.
        try (OutputStream os = conn.getOutputStream()) {
            os.write(jsonPayload.getBytes());
            os.flush();
        }

        int statusCode = conn.getResponseCode();
        System.out.println("Status Code: " + statusCode);
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()
        ));

        String output;
        StringBuilder sb = new StringBuilder();
        while ((output = br.readLine()) != null) {
            sb.append(output).append(System.lineSeparator());
            System.out.println(output);
        }
        conn.disconnect();

        return sb.toString();
    }
}
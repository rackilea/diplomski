import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SamodzielnaListaOsob extends JFrame {

    JButton dodaj, erease;
    JTextField film;
    DefaultListModel<String> listFilm;
    DefaultTableModel tableFilm;
    JList<String> lista = null;

    JRadioButton sevenbutton = new JRadioButton("7");
    JRadioButton twbutton = new JRadioButton("12");
    JRadioButton sixbutton = new JRadioButton("16");
    JRadioButton eightbutton = new JRadioButton("18");

    JCheckBox Horror = new JCheckBox("Horror");
    JCheckBox Komedia = new JCheckBox("Comedy");
    JCheckBox Thriller = new JCheckBox("Thriller");

    ButtonGroup bg1 = new ButtonGroup();

    public SamodzielnaListaOsob(String title) {
        super(title);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        final JTextField film = new JTextField("Wpisz tytul filmu", 10);
        film.setBorder(BorderFactory.createTitledBorder("Film"));

        JPanel p1 = new JPanel();
        p1.add(film);

        JButton dodaj = new JButton("Add to list");
        dodaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nowyFilm = film.getText();
                if (nowyFilm != "") {
                    listFilm.addElement(nowyFilm);
                    film.setText("");
                }
            }
        });
        JButton erease = new JButton("Clear");
        erease.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                film.setText("");

            }
        });
        JButton dodajDoTabeli = new JButton("Add to table");
        dodajDoTabeli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nowyFilm = film.getText();
                if (nowyFilm != "") {
                    int ile = tableFilm.getRowCount();
                    String title = lista.getSelectedValue();
                    int age;
                    if (sixbutton.isSelected()) {
                        age = 16;
                    } else if (sevenbutton.isSelected()) {
                        age = 7;
                    } else if (eightbutton.isSelected()) {
                        age = 18;
                    } else {
                        age = 12;
                    }
                    String genres = "";
                    if (Horror.isSelected()) {
                        genres += "Horror, ";
                    }
                    if (Komedia.isSelected()) {
                        genres += "Komedia, ";
                    }
                    if (Thriller.isSelected()) {
                        genres += "Thriller";
                    }

                    String desc = title + ", " + age + ", " + genres;
                    tableFilm.addRow(new Object[]{ile + 1, nowyFilm, desc});
                }
            }
        });

        bg1.add(sevenbutton);
        bg1.add(twbutton);
        bg1.add(sixbutton);
        bg1.add(eightbutton);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(4, 0));
        radioPanel.add(sevenbutton);
        radioPanel.add(twbutton);
        radioPanel.add(sixbutton);
        radioPanel.add(eightbutton);

        radioPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Age"));
        radioPanel.setSize(200, 200);

        JCheckBoxMenuItem listac = new JCheckBoxMenuItem();
        listac.add(Horror);
        listac.add(Komedia);
        listac.add(Thriller);

        JPanel listaChceck = new JPanel();
        listaChceck.add(Horror);
        listaChceck.add(Komedia);
        listaChceck.add(Thriller);
        listaChceck.setLayout(new GridLayout(3, 0));

        JPanel p2 = new JPanel();
        p2.add(dodaj);
        p2.add(erease);
        p2.add(dodajDoTabeli);
        p2.add(radioPanel);
        p2.add(listaChceck);

        listFilm = new DefaultListModel<String>();
        listFilm.addElement("Achacy");
        listFilm.addElement("Bonifacy");
        listFilm.addElement("Cezary");

        lista = new JList<String>(listFilm);
        JScrollPane sl = new JScrollPane(lista);
        sl.setPreferredSize(new Dimension(150, 150));
        sl.setBorder(BorderFactory.createTitledBorder("List"));

        String[] kolumnyTabeli = {"Nr", "Movie", "Description"};
        tableFilm = new DefaultTableModel(kolumnyTabeli, 0) {

        };
        JTable tabela = new JTable(tableFilm);
        JScrollPane st = new JScrollPane(tabela);
        st.setPreferredSize(new Dimension(300, 150));
        st.setBorder(BorderFactory.createTitledBorder("Table"));

        JPanel p3 = new JPanel();
        p3.add(sl);
        p3.add(st);


        p1.add(p2);
        p2.add(p3);
        setContentPane(p1);

        pack();
        setPreferredSize(new Dimension(900, 900));
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SamodzielnaListaOsob("List of movies");
            }
        });
    }

}
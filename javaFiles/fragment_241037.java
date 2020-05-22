import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class CreerModificationAbsence extends JDialog {

    private JPanel modificationAbsence1, modificationAbsence2, modificationAbsence3, panneauDateDebut, panneauDateFin;
    private JButton modifier, annuler;
    private JLabel raison, prenomNomEmpl, prenomNomChef;
    private JComboBox<String> raisonC, heureDebutC, heureFinC, minuteDebutC, minuteFinC;
    private JTextField prenomNomEmplT, prenomnomChefT;
    private final String[] raisonAbsence = { "Malade" };

    private JLabel dateDebut, dateFin;
    private JTextField dateDebutT, dateFinT;

    private final String[] heures = { "00" };
    private final String[] minutes = { "00", "15", "30", "45" };

    private BorderLayout gestionnaireComposant;
    private GridLayout gridGestionnaireComposant;
    private FlowLayout panneauMilieuLayout;
    final FlowLayout gestionnaireComposantBas;

    public CreerModificationAbsence() {
        super((Frame) null, "Modification - Absence d'employé", true);

        // setPreferredSize(new Dimension(600, 250));
        setAlwaysOnTop(true);
        setResizable(false);
        setAlwaysOnTop(true);
        gestionnaireComposant = new BorderLayout();
        this.getContentPane().setLayout(gestionnaireComposant);

        // Modification Panneau Haut

        modificationAbsence1 = new JPanel();

        gridGestionnaireComposant = new GridLayout(3, 2, 2, 2);
        modificationAbsence1.setLayout(gridGestionnaireComposant);

        raison = new JLabel("Raison : ");
        raisonC = new JComboBox(raisonAbsence);
        raisonC.setEditable(true);
        prenomNomEmpl = new JLabel("Prénom et Nom de l'employé : ");
        prenomNomEmplT = new JTextField();
        prenomNomChef = new JLabel("Prénom et Nom du chef d'équipe : ");
        prenomnomChefT = new JTextField();

        modificationAbsence1.add(raison);
        modificationAbsence1.add(raisonC);
        modificationAbsence1.add(prenomNomEmpl);
        modificationAbsence1.add(prenomNomEmplT);
        modificationAbsence1.add(prenomNomChef);
        modificationAbsence1.add(prenomnomChefT);

        // Modification Panneau Milieu

        modificationAbsence2 = new JPanel();
        panneauDateDebut = new JPanel();
        panneauDateFin = new JPanel();

        panneauMilieuLayout = new FlowLayout();

        panneauDateDebut.setLayout(panneauMilieuLayout);
        panneauDateDebut.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        panneauDateFin.setLayout(panneauMilieuLayout);
        panneauDateFin.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        dateDebutT = new JTextField(12);
        heureDebutC = new JComboBox(heures);
        minuteDebutC = new JComboBox(minutes);
        dateFinT = new JTextField(12);
        heureFinC = new JComboBox(heures);
        minuteFinC = new JComboBox(minutes);

        dateDebut = new JLabel("Date de début :");
        dateFin = new JLabel("Date de fin :");

        panneauDateDebut.add(dateDebut);
        panneauDateDebut.add(dateDebutT);
        panneauDateDebut.add(heureDebutC);
        panneauDateDebut.add(minuteDebutC);
        panneauDateFin.add(dateFin);
        panneauDateFin.add(dateFinT);
        panneauDateFin.add(heureFinC);
        panneauDateFin.add(minuteFinC);
        modificationAbsence2.add(panneauDateDebut, BorderLayout.CENTER);
        modificationAbsence2.add(panneauDateFin, BorderLayout.PAGE_END);

        // Modification Panneau Bas

        modificationAbsence3 = new JPanel();
        gestionnaireComposantBas = new FlowLayout(FlowLayout.RIGHT);
        modificationAbsence3.setLayout(gestionnaireComposantBas);

        modifier = new JButton("Modifier");
        annuler = new JButton("Annuler");

        modificationAbsence3.add(modifier);
        modificationAbsence3.add(annuler);

        this.add(modificationAbsence1, BorderLayout.NORTH);
        this.add(modificationAbsence2, BorderLayout.CENTER);
        this.add(modificationAbsence3, BorderLayout.SOUTH);
        /*this.*/setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
        setLocationRelativeTo(null);
        /*this.*/setVisible(true);
    }

    public static void main(String s[]) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                CreerModificationAbsence textf = new CreerModificationAbsence();
            }
        });
    }

}
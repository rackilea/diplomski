import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
//!! import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Simplicity {

    public Simplicity() {

    }

    public static void main(String[] args) {

        Body fen = new Body();
        fen.setVisible(true);

    }

}

class Body extends JFrame{

   private static final long serialVersionUID = 1L;

   private static final int FRAME_WIDTH = 250;
   private static final int FRAME_HEIGHT = 400;

   private static JPanel niveauBase = new JPanel(); // Basic panel -> everything will go on it
   private static JPanel infosReseauxHeure = new JPanel(); // Panel fixed
   private JPanel panelChangeable = new JPanel(); // Scrolling panel

   // up of page info
   private static JTextPane infos = new JTextPane();

   // Creation of the different pages (panels)
   private Tutoriel tuto;

   public Body() {
       super();
       buildFrame();
       this.buildContentPane();
       this.setContentPane(niveauBase);
   }
   public void buildFrame() {
       this.setTitle("Simplicity");
       this.setResizable(false);
       this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.getContentPane().setBackground(new Color(255, 105, 86));

       // toutes les dimensions sont en relatif par rapport à la taille de la JFrame. de fait, en changeant celle-ci, on peut adapter l'interface à différents écrans      

       // on met en place ce qui ne changera jamais d'un panel à l'autre --> les infos de base et le support
           // support
       niveauBase.setLayout(null);
       niveauBase.setBackground(Color.blue); //!!

           // basic info
       infosReseauxHeure.setOpaque(false);
       infosReseauxHeure.setBounds(0, 0, this.getWidth(), (int)(0.12*this.getHeight()));
       infosReseauxHeure.setLayout(new GridLayout(0,1));
       infosReseauxHeure.add(infos);

           // adding the text
       niveauBase.add(infosReseauxHeure);

       // defining the limits of the changing Panel, bc they are always the same
       panelChangeable.setOpaque(false);
       panelChangeable.setLayout(null);
       // My first try of changing the background 
//     panelChangeable.setBackground(new Color(255, 105, 86));
       panelChangeable.setBounds(0, infosReseauxHeure.getHeight(), this.getWidth(), (int) (0.88*this.getHeight()));
       niveauBase.add(panelChangeable);

       // the basic frame, which will never change, is ready.

   }
   public void buildContentPane() {

       // Instantiation of the pages

       tuto = new Tutoriel(this);
       /*
       ac1 = new Accueil1(this);
       ac2 = new Accueil2(this);
       med1 = new Medias1(this);
       multimed1 = new Multimedias1(this);
       out1 = new Outils1(this);
       out2 = new Outils2(this);
       jeux1 = new Jeux1(this);
       jeux2 = new Jeux2(this);
       socInt1 = new SocialInternet1(this);
       socInt2 = new SocialInternet2(this);

       appeler = new Appeler(this);
       urgences = new Urgences(this);

       appelEnCours = new AppelEnCours(this);
       demarrageApp = new DemarrageApp(this);
       enConstruction = new EnConstruction(this);
       */

       // Tutoriel is the first to be displayed
       CaractsPanelChangeant(tuto);
       panelChangeable.add(tuto);

       // all the other panels have the same displaying characteristics
       // navigating panels
       /*
       addPanels(ac1);
       addPanels(ac2);
       addPanels(med1);
       addPanels(multimed1);
       addPanels(out1);
       addPanels(out2);
       addPanels(jeux1);
       addPanels(jeux2);
       addPanels(socInt1);
       addPanels(socInt2);

       // applications panels
       addPanels(appeler);
       addPanels(urgences);

       // diverse panels
       addPanels(appelEnCours);
       addPanels(demarrageApp);
       addPanels(enConstruction);
       */
   }
   // fixating the same size and origins for all the panels
   public void CaractsPanelChangeant(JPanel a) {

       a.setBounds(0, 0, panelChangeable.getWidth(), panelChangeable.getHeight());
   }
   // regroup the same actions for the panels : bounds, adding and invisible
   public void addPanels(JPanel a) {
       CaractsPanelChangeant(a);
       panelChangeable.add(a);
       a.setVisible(false);
       /*
        * I tried to change the background here too
       a.setOpaque(true);
       a.setBackground(new Color(255, 105, 86));
       */
   }

   // JPanel getters
   public static int getInfosReseauxHeureHeight() {
       return infosReseauxHeure.getHeight();
   }
   /*
   public Accueil1 getAc1() {
       return ac1;
   }
   public Accueil2 getAc2() {
       return ac2;
   }
   public Medias1 getMed1() {
       return med1;
   }
   public Multimedias1 getMultimed1() {
       return multimed1;
   }
   public Outils1 getOut1() {
       return out1;
   }
   public Outils2 getOut2() {
       return out2;
   }
   public Jeux1 getJeux1() {
       return jeux1;
   }
   public Jeux2 getJeux2() {
       return jeux2;
   }
   public SocialInternet1 getSocInt1() {
       return socInt1;
   }
   public SocialInternet2 getSocInt2() {
       return socInt2;
   }

   public Appeler getAppeler() {
       return appeler;
   }
   public Urgences getUrgences() {
       return urgences;
   }
   public AppelEnCours getAppelEnCours() {
       return appelEnCours;
   }
   public DemarrageApp getDemarrageApp() {
       return demarrageApp;
   }
   public EnConstruction getEnConstruction() {
       return enConstruction;
   }
   */
   public Tutoriel getTuto() {
       return tuto;
   }

   // other getters
   public static int getFrameWidth() {
       return FRAME_WIDTH;
   }
   public static int getFrameHeight() {
       return FRAME_HEIGHT;
   }
   public JPanel getPanelChangeable() {
       return panelChangeable;
   }

   // setters
   public void setPanelChangeable(JPanel a) {
       this.panelChangeable = a;
   }
   /*
   public void switchAccueil(){
       ac1.setVisible(!ac1.isVisible());
       ac2.setVisible(!ac2.isVisible());
   }
   */
}

class Tutoriel extends JPanel {

   private static final long serialVersionUID = 1L;

   private Body body;

   // panels
   private JPanel tout;
   private JPanel centre;
   private JPanel messageCentre1;
   private JPanel messageCentre2;

   // buttons
   private JButton ok1;
   private JButton ok2;

   private JLabel messageHaut;
   private JLabel tuto1;
   private JLabel FGauche;
   private JLabel FDroite;
   private JLabel tuto2;
   private JCheckBox tutoOff;

   //private Color fond = new Color(255, 105, 86);


   public Tutoriel(Body body) {
       super();
       this.body = body;
       buildTuto();
       setOpaque(false);
   }
   public void buildTuto() {

       this.setLayout(new GridLayout(0,1));
       tout = new JPanel();
       tout.setOpaque(false); //!!
       tout.setLayout(new BorderLayout(0,0));
       this.add(tout);

       // tutorial announce
       messageHaut = new JLabel("TUTORIEL");
       messageHaut.setForeground(new Color(0, 0, 0));
       messageHaut.setFont(new Font("Arial", Font.BOLD, 20));
       messageHaut.setHorizontalAlignment(JLabel.CENTER);
       tout.add(messageHaut, BorderLayout.NORTH);

       // central panel, with the tutorial
       centre = new JPanel();
       centre.setOpaque(false);
       centre.setLayout(null);
       tout.add(centre, BorderLayout.CENTER);

       // first tutorial
       messageCentre1 = new JPanel();
       messageCentre1.setLayout(null);
       messageCentre1.setOpaque(false);
       messageCentre1.setBounds(0, 0, 250, 300);
       centre.add(messageCentre1);

       tuto1 = new JLabel("<html>POUR NAVIGUER ENTRE<br>LES DIFFÉRENTES PAGES<br>UTILISER LES FLÈCHES</html>");
       tuto1.setForeground(new Color(0, 0, 0));
       tuto1.setFont(new Font("Arial", Font.BOLD, 16));
       tuto1.setHorizontalAlignment(JLabel.CENTER);
       tuto1.setVerticalAlignment(JLabel.CENTER);
       tuto1.setBounds(20, -10, 200, 150);
       messageCentre1.add(tuto1);

       // arrows
       FGauche = new JLabel("G");
       //!! FGauche.setIcon(new ImageIcon(getClass().getResource("/img/left-blue.png")));
       FGauche.setBackground(new Color(255, 153, 0));
       FGauche.setBounds(80, 150, 40, 40);
       messageCentre1.add(FGauche);

       FDroite = new JLabel("D");
       //!! FDroite.setIcon(new ImageIcon(getClass().getResource("/img/right-blue.png")));
       FDroite.setBackground(new Color(255, 153, 0));
       FDroite.setBounds(140, 150, 40, 40);
       messageCentre1.add(FDroite);

       // OK button, first tutorial
       ok1 = new JButton(new SelectAction(body));
       ok1.setActionCommand("tuto1");
       ok1.setText("OK");
       ok1.setMargin(new Insets(5, 5, 5, 5));
       ok1.setForeground(new Color(0, 0, 0));
       ok1.setBackground(new Color(255, 153, 0));
       ok1.setBounds(105, 230, 40, 40);
       messageCentre1.add(ok1);

       // second tutorial
       messageCentre2 = new JPanel();
       messageCentre2.setOpaque(false);
       messageCentre2.setLayout(null);
       messageCentre2.setBounds(0, 0, 250, 300);
       centre.add(messageCentre2);

       tuto2 = new JLabel("<html>POUR RETOURNER<br>A L'ACCUEIL, APPUYER<br>SUR LA TOUCHE G</html>");
       tuto2.setForeground(new Color(0, 0, 0));
       tuto2.setFont(new Font("Arial", Font.BOLD, 16));
       tuto2.setHorizontalAlignment(JLabel.CENTER);
       tuto2.setVerticalAlignment(JLabel.CENTER);
       tuto2.setBounds(20, -10, 200, 150);
       messageCentre2.add(tuto2);

       // OK button, second tutorial
       ok2 = new JButton(new SelectAction(body));
       ok2.setActionCommand("tuto2");
       ok2.setText("OK");
       ok2.setMargin(new Insets(5, 5, 5, 5));
       ok2.setForeground(new Color(0, 0, 0));
       ok2.setBackground(new Color(255, 153, 0));
       ok2.setBounds(105, 230, 40, 40);
       messageCentre2.add(ok2);

       // visibility of tutorial panels
       //messageCentre1.setVisible(false);
       messageCentre2.setVisible(false);

       // deactivate the tutorial (and reach the main page)
       tutoOff = new JCheckBox(new SelectAction(body));
       tutoOff.setActionCommand("tutoOff");
       tutoOff.setText("NE PLUS AFFICHER AU DÉMARRAGE");
       tutoOff.setForeground(new Color(0, 0, 0));
       tout.add(tutoOff, BorderLayout.SOUTH);
   }
   /*
   @Override
   public void paintComponent(Graphics g) {
       super.paintComponent(g);
       g.setColor(fond);
       g.drawOval(0, 0, 50, 50);
   }
   */
   public JPanel getMessageCentre1() {
       return messageCentre1;
   }
   public JPanel getMessageCentre2() {
       return messageCentre2;
   } 

}

// !! hadd to add this to get code to compile!
class SelectAction extends AbstractAction {
   private Body body;

   public SelectAction(Body body) {
      this.body = body;
   }

   @Override
   public void actionPerformed(ActionEvent evt) {
      // TODO put some junk in here!

   }
}
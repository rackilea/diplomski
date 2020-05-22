public class USPSCaseSpinController implements Initializable {

        @FXML
        private static Label USPName;

        @FXML
        private static Label USPWearName;

        @FXML
        private Button SpinUSPS;

        @FXML
        public static ImageView setUSPImage;

        @FXML
        private Button USPKeep;

        private List<Image> gunImages =  new ArrayList<>();

        @FXML
        private Button USPDiscard;

        @FXML
        private void handleSpinMechBack(MouseEvent event) throws IOException{
            Parent handleInventoryBackParent = FXMLLoader.load(getClass().getResource("/csgocaseopener/OpenCase.fxml"));
            Scene OPBackScene = new Scene(handleInventoryBackParent);
            Stage handleInventoryBackStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            handleInventoryBackStage.setScene(OPBackScene);
            handleInventoryBackStage.show();
        }


        @FXML
        private void SpinUSPSCase(ActionEvent event) throws IOException{
            Random rand = new Random();
            int gunSelect = rand.nextInt(99)+1;
            if(gunSelect<=30){
                LeadConduitUSPS();
            USPName.setText("Lead Conduit");
            }
            else if(gunSelect>=31 && gunSelect<=60){
                NightOpsUSPS();
                USPName.setText("Night Ops");
            }
            else if(gunSelect>=61 && gunSelect<=90){
                TorqueUSPS(); 
                USPName.setText("Torque");
            }
            else if(gunSelect>=91 && gunSelect<=93.5){
                GuardianUSPS();
                USPName.setText("Guardian");
            }
            else if(gunSelect>=94.5 && gunSelect<=97){
                CyrexUSPS();
                USPName.setText("Cyrex");
            }
            else if(gunSelect>=98 && gunSelect<=99){
                CaimanUSPS();
                USPName.setText("Caiman");
            }
            else if(gunSelect==100){
                KillConfirmedUSPS();
                USPName.setText("Kill Confirmed");
            }
            SpinUSPS.setDisable(true);
            USPKeep.setVisible(true);
            USPDiscard.setVisible(true);
        }

        @FXML
        private void handleUSPDiscard(ActionEvent event) throws IOException{
            SpinUSPS.setDisable(false);
            USPKeep.setVisible(false);
            USPDiscard.setVisible(false);
            USPName.setText("");
            USPWearName.setText("");
            setUSPImage.setImage(null);
        }

        @FXML
        public void handleUSPKeep(ActionEvent event) throws IOException{
           SpinUSPS.setDisable(false);
           USPKeep.setVisible(false);
           USPDiscard.setVisible(false);
           USPName.setText("");
           USPWearName.setText("");
           setUSPImage.setImage(null);

           gunImages.add(0, new Image("GunImages/USPLead Conduit.png"));
           gunImages.add(1, new Image("GunImages/USPNight Ops.png"));
           gunImages.add(2, new Image("GunImages/USPTorque.png"));
           gunImages.add(3, new Image("GunImages/USPGaurdian.png"));
           gunImages.add(4, new Image("GunImages/USPCyrex.png"));
           gunImages.add(5, new Image("GunImages/USPCaiman.png"));
           gunImages.add(6, new Image("GunImages/USPKill Confirmed.png"));

           ImageView setUSPImage = new ImageView(gunImages.get(0));

           if(setUSPImage.getImage().equals(gunImages.get(0))){
              System.out.println("Lead Conduit");
           }
           else if(setUSPImage.getImage().equals(gunImages.get(1))){
              System.out.println("Night Ops");
           }
           else if(setUSPImage.getImage().equals(gunImages.get(2))){
               System.out.println("Torque");
           }
           else if(setUSPImage.getImage().equals(gunImages.get(3))){
               System.out.println("Guardian");
           }
           else if(setUSPImage.getImage().equals(gunImages.get(4))){
               System.out.println("Cyrex");
           }
           else if(setUSPImage.getImage().equals(gunImages.get(5))){
               System.out.println("Caiman");
           }
           else if(setUSPImage.getImage().equals(gunImages.get(6))){
              System.out.println("Kill Confirmed");
           }
        }

        public static void LeadConduitUSPS(){
            int x =0;
            setUSPImage.setImage(gunImages.get(0));
            Random rand = new Random();
            int wareSelect = rand.nextInt(99)+1;

            if(wareSelect<=10){ //Calculates the ware the gun has
                USPWearName.setText("Factory New");
            }
            else if(wareSelect>=11 && wareSelect<=25){
                USPWearName.setText("Minimal Wear");
            }
            else if(wareSelect>=26 && wareSelect<=60){
                USPWearName.setText("Field Tested");
            }
            else if(wareSelect>=61 && wareSelect<=80){
                USPWearName.setText("Well Worn");
            }
            else if(wareSelect>=81){
                USPWearName.setText("Battle Scarred");
            }
    }
    public static void NightOpsUSPS(){
        int x = 1;
        setUSPImage.setImage(gunImages.get(1));

        Random rand = new Random();
        double wareSelect = rand.nextInt(99)+1;

        if(wareSelect<=10){ //Calculates the ware the gun has
            USPWearName.setText("Factory New");
        }
        else if(wareSelect>=11 && wareSelect<=25){
            USPWearName.setText("Minimal Wear");
        }
        else if(wareSelect>=26 && wareSelect<=60){
            USPWearName.setText("Field Tested");
        }
        else if(wareSelect>=61 && wareSelect<=80){
            USPWearName.setText("Well Worn");
        }
        else if(wareSelect>=81){
            USPWearName.setText("Battle Scarred");
        }
    }
    public static void TorqueUSPS(){
        int x = 2;
        setUSPImage.setImage(gunImages.get(2));

        Random rand = new Random();
        double wareSelect = rand.nextInt(99)+1;

        if(wareSelect<=10){ //Calculates the ware the gun has
            USPWearName.setText("Factory New");
        }
        else if(wareSelect>=11 && wareSelect<=25){
            USPWearName.setText("Minimal Wear");
        }
        else if(wareSelect>=26 && wareSelect<=60){
            USPWearName.setText("Field Tested");
        }
        else if(wareSelect>=61 && wareSelect<=80){
            USPWearName.setText("Well Worn");
        }
        else if(wareSelect>=81){
            USPWearName.setText("Battle Scarred");
        }
    }
    public static void GuardianUSPS(){
        int x = 3;
        setUSPImage.setImage(gunImages.get(3));

        Random rand = new Random();
        double wareSelect = rand.nextInt(99)+1;

        if(wareSelect<=10){ //Calculates the ware the gun has
            USPWearName.setText("Factory New");
        }
        else if(wareSelect>=11 && wareSelect<=50){
            USPWearName.setText("Minimal Wear");
        }
        else if(wareSelect>=51){
            USPWearName.setText("Field Tested");
        }
    }
    public static void CyrexUSPS(){
        int x = 4;
        setUSPImage.setImage(gunImages.get(4));

        Random rand = new Random();
        double wareSelect = rand.nextInt(99)+1;

        if(wareSelect<=10){ //Calculates the ware the gun has
            USPWearName.setText("Factory New");
        }
        else if(wareSelect>=11 && wareSelect<=25){
            USPWearName.setText("Minimal Wear");
        }
        else if(wareSelect>=26 && wareSelect<=60){
            USPWearName.setText("Field Tested");
        }
        else if(wareSelect>=61 && wareSelect<=80){
            USPWearName.setText("Well Worn");
        }
        else if(wareSelect>=81){
            USPWearName.setText("Battle Scarred");
        }
    }
    public static void CaimanUSPS(){
        int x = 5;
        setUSPImage.setImage(gunImages.get(5));

        Random rand = new Random();
        double wareSelect = rand.nextInt(99)+1;

        if(wareSelect<=10){ //Calculates the ware the gun has
            USPWearName.setText("Factory New");
        }
        else if(wareSelect>=11 && wareSelect<=35){
            USPWearName.setText("Minimal Wear");
        }
        else if(wareSelect>=36 && wareSelect<=75){
            USPWearName.setText("Field Tested");
        }
        else if(wareSelect>=76){
            USPWearName.setText("Well Worn");
        }
    }
    public static void KillConfirmedUSPS(){
        int x = 6;
        setUSPImage.setImage(gunImages.get(6));

        Random rand = new Random();
        double wareSelect = rand.nextInt(99)+1;

        if(wareSelect<=10){ //Calculates the ware the gun has
            USPWearName.setText("Factory New");
        }
        else if(wareSelect>=11 && wareSelect<=24){
            USPWearName.setText("Minimal Wear");
        }
        else if(wareSelect>=36 && wareSelect<=60){
            USPWearName.setText("Field Tested");
        }
        else if(wareSelect>=61 && wareSelect<=85){
            USPWearName.setText("Well Worn");
        }
        else if(wareSelect>=86){
            USPWearName.setText("Battle Scarred");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
}
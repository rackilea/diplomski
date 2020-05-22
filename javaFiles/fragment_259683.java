ConnectionHelper ch=new ConnectionHelper();
ch.Connect();
String q="SELECT IMG FROM img_ins";

Statement st=ch.con.createStatement();
ResultSet rs = st.executeQuery(q);

if (rs.next()) {
    InputStream is= rs.getBinaryStream("IMG");

    // instead of the next 9 lines, you could just do
    // javafx.scene.image.Image image1 = new Image(is);

    OutputStream os=new FileOutputStream(new File("img.jpg"));
    byte [] content= new byte[1024];
    int size=0;


        while ((size=is.read(content))!=-1){

            os.write(content, 0, size);
        }

    os.close();
    is.close();

    javafx.scene.image.Image image1=new Image("file:img.jpg", image.getFitWidth(), image.getFitHeight(), true, true);
    image.setImage(image1);
    image.setPreserveRatio(true);
}
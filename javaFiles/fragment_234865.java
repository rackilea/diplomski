private Connection conn;

@Override
public void init() throws Exception {
    MysqlDataSource dataSource = new MysqlDataSource();
    dataSource.setUser(USERNAME);
    dataSource.setPassword(PASSWORD);
    dataSource.setServerName(SERVER);
    dataSource.setDatabaseName(DATABASE_NAME);
    conn = dataSource.getConnection();

    try (Statement stm = conn.createStatement()) {
        // initialize table
        stm.execute("CREATE TABLE IF NOT EXISTS images ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "image LONGBLOB)");
    }
}

@Override
public void stop() throws Exception {
    if (conn != null) {
        conn.close();
    }
}

@Override
public void start(Stage primaryStage) {
    ImageView imageView = new ImageView();
    Button open = new Button("open");
    Button submit = new Button("submit");
    Button retrieve = new Button("retrieve");
    TextField tf = new TextField();
    TextFormatter<Integer> formatter = new TextFormatter<>(new IntegerStringConverter());
    tf.setTextFormatter(formatter);

    open.setOnAction(evt -> {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(primaryStage);
        if (file != null) {
            Image image = new Image(file.toURI().toString());
            imageView.setImage(image);
        }
    });

    submit.setOnAction(evt -> {
        Image image = imageView.getImage();
        Integer id = formatter.getValue();
        if (image != null && id != null) {
            try (PreparedStatement stm = conn.prepareStatement("INSERT INTO images (id, image) VALUES (?, ?) ON DUPLICATE KEY UPDATE image = ?")) {
                // write data to in-memory stream
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                BufferedImage bi = SwingFXUtils.fromFXImage(image, null);
                ImageIO.write(bi, "jpg", bos);

                Blob blob = new SerialBlob(bos.toByteArray());
                stm.setInt(1, id);
                stm.setBlob(2, blob);
                stm.setBlob(3, blob);
                stm.executeUpdate();
            } catch (IOException | SQLException ex) {
                ex.printStackTrace();
            }
        }
    });

    retrieve.setOnAction(evt -> {
        Integer id = formatter.getValue();
        if (id != null) {
            imageView.setImage(null);
            try (PreparedStatement stm = conn.prepareStatement("SELECT image FROM images WHERE id = ?")) {
                stm.setInt(1, id);
                ResultSet rs = stm.executeQuery();
                if (rs.next()) {
                    // read image data from db
                    Blob data = rs.getBlob(1);
                    imageView.setImage(new Image(data.getBinaryStream()));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    });
    VBox root = new VBox(tf, new HBox(open, submit, retrieve), imageView);

    Scene scene = new Scene(root, 500, 500);

    primaryStage.setScene(scene);
    primaryStage.show();
}
String imgsrc = this.getClass().getClassLoader()
            .getResource("your_package_name/image.png").toString();

    editor_pane.setContentType("text/html");
    editor_pane.setEditable(false);
    editor_pane.setText("<h3>Image Title</h3><img src='" + imgsrc + "' alt='img' name='img_name' width='100' height='100' /><br />");
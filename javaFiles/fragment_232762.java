String imgURL = "data:image/png;base64,iVBORw0KGgoAA.........";
        editor_pane.setContentType("text/html");
        editor_pane.setEditable(false);
        CustomToolKit toolKit = new CustomToolKit();
        editor_pane.setEditorKit(toolKit);
        editor_pane.setText("<h1>Image Title</h1><img src='" + imgURL + "' alt='img_alt' width='150' height='150' /><br />");
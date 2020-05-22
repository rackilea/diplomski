GL.setHorizontalGroup(GL.createSequentialGroup()
        .addGroup(GL.createParallelGroup(LEADING)
            .addComponent(lbl_mem_settings)
            .addComponent(lbl_mem_select)) //here you attach the label
        .addGroup(GL.createParallelGroup(LEADING)
            .addComponent(cb_mem_select))
    );
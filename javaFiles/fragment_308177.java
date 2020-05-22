GL.setVerticalGroup(GL.createSequentialGroup()
        .addGroup(GL.createParallelGroup(BASELINE)
            .addComponent(lbl_mem_settings)
            .addComponent(lbl_mem_select)) //add this line
        .addGroup(GL.createParallelGroup(BASELINE)
            .addComponent(lbl_mem_settings)
            .addComponent(cb_mem_select))  
    );
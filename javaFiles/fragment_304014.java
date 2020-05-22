JobDAO jdao = new JobDAO(conn);
       //create object jobDTO to hold all form values to be passed to JobDAO
       final JobDTO jobDTO = new JobDTO();
       //populating JobDTO with values from form
       jobDTO.setEmployerID(id);
       jobDTO.setDescription(description.getText());
       jobDTO.setTitle(txtTitle.getText());
       jdao.create(jobDTO);
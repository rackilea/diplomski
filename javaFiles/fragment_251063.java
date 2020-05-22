public void addMOJOsFromJARResource() {
      try {
        String[] mojo_names = this.getMOJONames();
        for (int i = 0; i < mojo_names.length; i++) {
            MojoReaderBackend reader =
                MojoReaderBackendFactory.createReaderBackend(
                  getClass().getResourceAsStream(
                     "/models/"+mojo_names[i]), 
                      MojoReaderBackendFactory.CachingStrategy.MEMORY);
            MojoModel model = ModelMojoReader.readFrom(reader);
            this.addModel(model);
        }
       } catch (Exception e) {
         e.printStackTrace();
        throw new RuntimeException();
        }
    }
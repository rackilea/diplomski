ObservableList<Model> lst = FXCollections.observableArrayList();
    String path = "G:\\";
    String line;
    File masterFile = new File(path,"masterfile.txt");
    BufferedReader readMasterFile = new BufferedReader(new FileReader(masterFile));

    while ((line = readMasterFile.readLine()) != null) {

          String[] data =line.split(";");
          Model md= new Model(data);
          lst.add(md);
   }
   table.setItems(lst);
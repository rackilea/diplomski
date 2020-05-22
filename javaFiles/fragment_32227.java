ObservableList<Consultation> consultationData = FXCollections.observableArrayList();
tableDevices.setItems(consultationData);
int index = 0;
//here you have to add each instance of the class consultation  
columnComboBox.setCellFactory(new Callback<TableColumn< Consultation, Consultation >, TableCell< Consultation, Consultation >>() {

        @Override public TableCell< Consultation, Consultation> call(TableColumn< Consultation, Consultation > cbCol) {
            return new TableCell< Consultation, Consultation >() {


                final ComboBox comboBox = new ComboBox(); 
                {                    
                    comboBox .setId(String.valueOf(index));

                }
                @Override public void updateItem(final Consultation consultation, boolean empty) {

                    super.updateItem(consultation, empty);

                    if (Consultation != null) {


                            if(index<=consultationData.size()){

                                System.out.println(consultation.getConsultationID());//just to see
                                comboBox.setItems((ObservableList) consultation.getStudents());                                   

                            }

                            index++;

                    }
                }

            };

        }

    });
GridCellRenderer<AttendanceCaseCreationModel> checkinRenderer=new GridCellRenderer<AttendanceCaseCreationModel>() {

        @Override
        public Object render(AttendanceCaseCreationModel model, String property,
                ColumnData config, int rowIndex, int colIndex,
                ListStore<AttendanceCaseCreationModel> store,
                Grid<AttendanceCaseCreationModel> grid) {

            String color="pink";
            if(eventcombo.getValue()!=null){


                if(eventcombo.getRawValue().equalsIgnoreCase("Forgot To Checkin") || 
                        eventcombo.getRawValue().equalsIgnoreCase("Mark/Modify Attendance")){
                    color="pink";
                }
                else{

                    config.style=config.style+ ";visibility: hidden;";
                }

            }

            config.style=config.style+ ";background-color:" + color  + ";";
            config.style=config.style+ ";display: block;";
            Object value = model.get(property);
            return value;

        }
    };
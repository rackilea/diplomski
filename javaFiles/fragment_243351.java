while ((line = br.readLine()) != null) {

        // use comma as separator

        String[] bookingdata = line.split(cvsSplitBy);

        location = bookingdata[1];
        ComboBoxModel model = cmb1.getModel();
        int size = model.getSize();
        // add all location in set and set will only allow distinct values
        locationSet.add(location);

       }
       // after looping through all location put it in combobox
       for(String location:locationSet)cmb1.addItem(location);
   }
  }
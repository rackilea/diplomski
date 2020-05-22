class data {
    String information[];

    data(String input[]) {
        information = input;
    }

    @Override
    public String toString() {
        return "Activity Name: " + information[0] + ", Duration: " 
                + information[1] + ", Predecessors: " +information[2];
    }
}

ArrayList<data> Input = new ArrayList<>();

private void nextActivityActionPerformed(java.awt.event.ActionEvent evt) {                                             

    // Take data from the text fields..
    String activityName = activityNameField.getText();
    String activityDuration_String = activityDurationField.getText();
    String dependantActivities = activityPredeField.getText();

    // Store this data in an array of size 3..
    String input[] = new String[3];
    input[0] = activityName;
    input[1] = activityDuration_String;
    input[2] = dependantActivities;

    // Store it in our global list..
    Input.add(new data(input));

    // set text fields empty so that new input can be taken..
    activityNameField.setText("");
    activityDurationField.setText("");
    activityPredeField.setText("");
}                                            

private void doneActionPerformed(java.awt.event.ActionEvent evt) {                                     

    // Take data from the text fields..
    String activityName = activityNameField.getText();
    String activityDuration_String = activityDurationField.getText();
    String dependantActivities = activityPredeField.getText();

    // A condition to check if the last entry was left taken as an input..
    boolean condition = (activityName.equals("")) && (activityDuration_String.equals("")) 
                        && (dependantActivities.equals(""));

    // if all 3 inputs are not empty then..
    // You can change as per your requirements....
    if(!condition) {                                
        // Store this data in an array of size 3..
        String input[] = new String[3];
        input[0] = activityName;
        input[1] = activityDuration_String;
        input[2] = dependantActivities;

        // Store it in our global list..
        Input.add(new data(input));

        // set text fields empty so that new input can be taken..
        activityNameField.setText("");
        activityDurationField.setText("");
        activityPredeField.setText("");
    }

    for(data inp : Input) 
        System.out.println(inp);        // Just print the stored data...
}
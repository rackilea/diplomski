sportCar.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        userHorsepower = JOptionPane.showInputDialog("Enter Horsepower");
        horsepower = Double.parseDouble(userHorsepower);

        userWeight = JOptionPane.showInputDialog("Enter Weight");
        weight = Double.parseDouble(userWeight);

        userTopspeed = JOptionPane.showInputDialog("Enter Topspeed");
        topspeed = Double.parseDouble(userTopspeed);

        aerodynamics = 0.5;
        userInput = "Sports Car";

        // These static methods would be added to your TestConsumption class
        acceleration = TestConsumption.calculateAcceleration(...whatever params required for this calculation...);
        fuelConsumption = TestConsumption.calculateFuelConsumption(...whatever params required for this calculation...);

        accel.setText("Acceleration: " + acceleration);
        fuel.setText("Fuel Consumption: " + fuelConsumption);

        panel.repaint();
}});
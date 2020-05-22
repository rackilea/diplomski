private void setMatrixParameters(){
    if(tfTouristNumber.getText().equals("") || tfRowNumber.getText().equals("") || tfColumnNumber.getText().equals("") || tfMinimal.getText().equals("")){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "All fields must be filled", "Error!", JOptionPane.ERROR_MESSAGE);
      return;
    }

    // Read values here. (Should probably add a try-catch block around this, in case it can't be parsed as number)
    int inTouristNumber = Integer.parseInt(tfTouristNumber.getText());
    int inRow = Integer.parseInt(tfRowNumber.getText());
    int inColumn = Integer.parseInt(tfColumnNumber.getText());
    int inMin = Integer.parseInt(tfMinimal.getText());

    //check the matrix dimensions
    if(inMin + inTouristNumber > inRow * inColumn){
        int dimension= inMin + inTouristNumber;
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Matrix dimensions too small. Need to be at least:" + dimension, "Enlarge matrix!", JOptionPane.ERROR_MESSAGE);
    }
    else{
        this.touristNumber = inTouristNumber;
        this.matrix = new Object[inRow][inColumn];
        this.min = inMin;
    }
}
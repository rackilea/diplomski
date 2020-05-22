@Override
public void actionPerformed(ActionEvent e){     
    if(e.getSource() == butt)
    {   
        // If you want to, you could pass the "old" value
        firePropertyChange("change", null, "she");
    }
}
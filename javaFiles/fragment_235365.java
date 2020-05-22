@Override
public void actionPerformed(ActionEvent arg0) {
    for (FactoryButton component : components) {
        if(component.getButton().equals(arg0.getSource()) && component instanceof FactorySelectionButton)
             selectedItem = ((FactorySelectionButton) component).getFactory();
        return;
    }
    //other buttons implementation
}
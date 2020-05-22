public void updateData(String parameters) {
    try {
        this.stmt.executeUpdate(parameters);
        this.setChanged();
        this.notifyObservers();        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
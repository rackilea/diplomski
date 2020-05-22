public void generuj() {
    ...
    akcja = new ActionListener() {
    public void actionPerformed( ActionEvent event) {
        String[] args = null;
        PDF.main(args);
        //interfejs.getguzikgeneruj().addActionListener(akcja);   
    }
    };
    // new location...
    interfejs.getguzikgeneruj().addActionListener(akcja);   
}
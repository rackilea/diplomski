final JProgressBar progressBar = new JProgressBar(0, 100);
final JTextArea textArea = new JTextArea();
final JButton button = new JButton("Start");

button.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
        HashMap<String, Number> map = Maps.newHashMap();
        map.put("experimentsInSession", 10);
        map.put("howManyTicks", 5);

        Model task = new Model(map, textArea);
        task.addPropertyChangeListener(
                 new PropertyChangeListener() {
                     public  void propertyChange(PropertyChangeEvent evt) {
                         if ("progress".equals(evt.getPropertyName())) {
                             progressBar.setValue((Integer)evt.getNewValue());
                         }
                     }
                 });
        task.execute();
    }
});
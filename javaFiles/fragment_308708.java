@Override
        public void actionPerformed(ActionEvent e)
        {
            Graph graph = new Graph();
            graph.gui = GUI.this;
            graph.Graph();
            setStartCity(startLocTextField.getText());
            setEndCity(endLocTextField.getText());
        }
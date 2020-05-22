/**
 * returns a JPanel that shows configuration options for this outputprovider,
 * after initializing the JPanel with current output options
 */
public JPanel getConfigurationPanel();
/**
 * configures output options using values in configPanel, previously 
 * requested through getConfigurationPanel
 */
public void configureFromPanel(JPanel configPanel) throws BadConfigException;
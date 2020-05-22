import de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel;


try {
    UIManager.setLookAndFeel(new SyntheticaClassyLookAndFeel());
} catch (Exception e) {
    e.printStackTrace();
}
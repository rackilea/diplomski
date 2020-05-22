private boolean isRunningJavaWebStart() {
    boolean hasJNLP = false;
    try {
      Class.forName("javax.jnlp.ServiceManager");
      hasJNLP = true;
    } catch (ClassNotFoundException ex) {
      hasJNLP = false;
    }
    return hasJNLP;
}
node() {
  def jdk8 = tool 'jdk-8u45'
  def jdk7 = tool 'jdk-7u70'
  withEnv(["PATH+JDK7=${jdk7}/bin"]) {
    sh 'ant [normal target here]'
  }
  withEnv(["PATH+JDK8=${jdk8}/bin"]) {
    sh 'ant [analysis target here]'
  }
}
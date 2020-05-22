class CommandFactory extends Factory[Command] {

  override def create():Command = {
    new Command() {
      def destroy() {}

      def setInputStream(in: InputStream) {}

      def setErrorStream(err: OutputStream) {}

      def setOutputStream(out: OutputStream) {}

      def start(env: Environment) {}

      def setExitCallback(callback: ExitCallback) {}
    }
  }
}
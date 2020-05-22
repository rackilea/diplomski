class Plugin {
   void Activate() {
      while (true)
         if (temporaryFile.hasChanged())
            doSomething();
   }
}
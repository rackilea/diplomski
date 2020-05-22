interface Editable {
   void changeName(String name);

   String getName();
}

class EditorAssistant implements Editable {
   private String name = "";

   @Override
   public void changeName(String name) {
      this.name = name;
   }

   @Override
   public String getName() {
      return name;
   }
}

class SomethingEditor implements Editable {
   private EditorAssistant assistant = new EditorAssistant();

   @Override
   public void changeName(String name) {
      assistant.changeName(name);
   }

   @Override
   public String getName() {
      return assistant.getName();
   }
}

class SomeOtherEditor implements Editable {
   private EditorAssistant assistant = new EditorAssistant();

   @Override
   public void changeName(String name) {
      assistant.changeName(name);
   }

   @Override
   public String getName() {
      return assistant.getName();
   }
}
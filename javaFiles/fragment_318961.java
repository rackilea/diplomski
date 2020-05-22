@ApplicationScoped
class Global {
   void setDocInUse(boolean) { ... }
   boolean isDocInUse() { ... }
}

@RequestScoped
class MyDocEditor {

    @Inject Global global;

    public void edit() {
       if (global.isDocInUse()) { ... }
       else  { ... }
    }
}
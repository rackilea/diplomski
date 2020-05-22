interface ProgrammerInterview  {
    public void read();
}

class Website  {
    ProgrammerInterview p = new ProgrammerInterview () {
        public void read() {
            System.out.println("interface ProgrammerInterview class implementer");
       }
     };
}
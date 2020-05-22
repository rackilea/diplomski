public Command getCommandFromResponse(String response) throws IllegalArgumentException{
        String[] split = response.split(" ");

        if(split.length < 1){
          throw new IllegalArgumentException("Invalid command.");
        }
        if(split.length < 2){
          throw new IllegalArgumentException("You must enter an item.");
        }

        return new Command(split[0], split[1]);
      }

      class Command{
        String command;
        String item;

        public Command(){
          command = null;
          item = null;
        }

        public Command(String comm, String item){
          this.command = comm;
          this.item = item;
        }

        public void setCommand(String command){
            this.command = command;
        }

        public void setItem(String item){
            this.item = item;
        }

        public String getCommand(){
            return this.command;
        }

        public String getItem(){
          return this.item;
        }

        public String toString(){
          return this.command + ":" + this.item;
        }
      }
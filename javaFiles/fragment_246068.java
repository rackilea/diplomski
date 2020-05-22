public static void main(String [] args) {
        DataContainer dContainer = null;
    try {
        dContainer = dataStreams();
    } catch (IOException e) {
        e.printStackTrace();
    }
    //do some logging with properties
    System.out.println(dContainer.getFirst());
    System.out.println(dContainer.getSecond());
    System.out.println(dContainer.getUtf());
    }

    public static DataContainer dataStreams() throws IOException { 
        int i = 0;
        char c;
        try (DataInputStream input = new DataInputStream(
                new FileInputStream("input.dat"));
        ) {

            while((i=input.read())!=-1){
                 // converts integer to character
                c=(char)i;
            }



            String stringUTF = input.readUTF();
            int firstInt = input.readInt();
            int secondInt = input.readInt();

            DataContainer dContainer = new DataContainer(stringUTF, firstInt, secondInt);
            return dContainer;
        }


    }

    static class DataContainer {
        String utf;
        int first;
        int second;
        DataContainer(String utf, int first, int second) {
            this.utf = utf;
            this.first = first;
            this.second = second;
        }
        public String getUtf() {
            return utf;
        }
        public int getFirst() {
            return first;
        }
        public int getSecond() {
            return second;
        }

    }
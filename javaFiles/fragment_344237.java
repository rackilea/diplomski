try {
        FileInputStream fis=new FileInputStream("C://object.ser");
        ObjectInputStream ois=new ObjectInputStream(fis);
        WriteObject wo=null;
        WriteObject[] woj=new WriteObject[5];

        ArrayList<WriteObject> woi=new ArrayList<>();
        woi=(ArrayList<WriteObject>)ois.readObject();

        for(int i=0;i<woi.size();i++){
            woi.get(i).getvalues();
        }
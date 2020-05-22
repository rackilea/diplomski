public void windowOpened(WindowEvent e) {
    try {
        if(new File("Janezek.ser").exists()) {
            ObjectInputStream oos = new ObjectInputStream(new GZIPInputStream(new FileInputStream("Janezek.ser")));
            seznamLadij = (ArrayList<TovornaLadja>) oos.readObject();
            oos.close();
            System.out.println(seznamLadij);
        }
        else {
            //No file is there, start fresh
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
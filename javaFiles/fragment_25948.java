public void windowOpened(WindowEvent e) {
    try {
        ObjectInputStream oos = new ObjectInputStream(new GZIPInputStream(new FileInputStream("Janezek.ser")));
        seznamLadij = (ArrayList<TovornaLadja>) oos.readObject();
        oos.close();
        System.out.println(seznamLadij);
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
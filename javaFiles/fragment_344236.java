WriteObject wo=new WriteObject(20, "Mohan");
    WriteObject wo1=new WriteObject(21, "Mohanraj");

    ArrayList<WriteObject> woi=new ArrayList<>();
    try {
        FileOutputStream fop=new FileOutputStream("c://object.ser");
        ObjectOutputStream oos=new ObjectOutputStream(fop);
        woi.add(wo);
        woi.add(wo1);
        oos.writeObject(woi);

    } catch NotFoundException e) {
}
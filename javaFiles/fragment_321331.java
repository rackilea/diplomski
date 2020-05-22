MainCode mainCode;

    String name;
    int age;
    String address;

    public LookData(MainCode main) {
        this.mainCode = main;
        initComponents();
    }

    public void getData(){
        name = mainCode.getName();
        age = mainCode.getAge();
        address = mainCode.getAddress();
    }

    public void printData(){
        String data = null;
        data =  "BIODATA REPORT\n"
                + "Your Name    : "+name+"\n"
                + "Your Age     : "+age+"\n"
                + "Your Address : "+address+"\n";
        jTextArea2.setText(data);
    }
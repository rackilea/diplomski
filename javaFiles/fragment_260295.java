class Inquiry{
    String name;
    String mail;
    String tp;
    String message;

    public Inquiry(String name,String mail,String tp,String message){
        this.name = name;
        this.mail = mail;
        this.tp = tp;
        this.message = message;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getTp() {
        return tp;
    }
    public void setTp(String tp) {
        this.tp = tp;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
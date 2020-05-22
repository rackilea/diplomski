public class Foo implements Externalizable{
    private long userID;
    private String userName;
    private char[] userPassword;
    private int age;

    private boolean shouldSavePassword;

    public void setSavePassword(boolean shouldSavePassword){
        this.shouldSavePassword = shouldSavePassword;
    }

    void writeExternal(ObjectOutput out) throws IOException{
        out.writeObject(userID);
        out.writeObject(userName);
        out.writeObject(shouldSavePassword);

        if(shouldSavePassword){
            out.writeObject(userPassword);
        }

        out.writeObject(age);
    }

    void readExternal(ObjectInput in) throws IOException, ClassNotFoundException{
        userID = in.readLong();
        userName = (String) in.readObject();
        shouldSavePassword = readBoolean();

        if(shouldSavePassword){
            userPassword = (char[]) in.readObject();
        }

        age = in.readInt();
    }
}
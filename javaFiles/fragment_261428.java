public class Item {

    public boolean isKey() { 
        return false; 
    }
}

class Key extends Item {
    @Override
    public boolean isKey() {
        return true;
    }
}
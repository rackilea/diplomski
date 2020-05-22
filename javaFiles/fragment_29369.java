public enum Keys
{
    KEY_0 (11),
    KEY_1 (2),
    //and so on

    KEY_xy(4711);

    int id;
    Keys(int id){
        this.id = id
    }

    @override
    int ordinal(){
        return id;
    }
}
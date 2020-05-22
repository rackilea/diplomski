public class SizeProperties {

    private static SizeProperties _instance;
    private Sizes _selectedSize;

    public enum Sizes{SMALL, MEDIUM, LARGE}

    private SizeProperties(){
        _selectedSize = Sizes.SMALL;
    }

    public static SizeProperties getInstance(){
        if(_instance == null){
            _instance = new SizeProperties();
        }
        return _instance;
    }

    public Sizes getSelectedSize(){
        return _selectedSize;
    }

    public void setSelectedSize(Sizes size){
        _selectedSize = size;
    }
}
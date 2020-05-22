public enum NUMBER
{
    THREE(3),
    SIX(6), 
    NINE(9);

    NUMBER(int value){this.value = value;}

    private int value;

    public int getValue(){return value;}
}
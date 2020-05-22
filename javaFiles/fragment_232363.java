enum MyFlag{
    NONE,FIRST,SECOND,THIRD,FOURTH
}

MyFlag myFlag=MyFlag.NONE;

@Override
public void update(float dt) {
    if(myFlag==MyFlag.FIRST) {
        fire();
        myFlag=MyFlag.values()[myFlag.ordinal()+1]; // incremental change

        //or manually change

        myFlag=MyFlag.NONE;
    }
}
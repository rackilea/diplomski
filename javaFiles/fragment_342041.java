interface ISomeOperation{
    void process();
}

class ThatUsesTheWPILIBJ implements ISomeOperation{

    void process(){
      //use library here
    }

}

class ThatUsesYourMock implements ISomeOperation{
    void process(){
      //use your mock here
    }
}


public YourUIClass{

    private ISomeOperation _operatingClass;


    public YourUIClass(ISomeOperation  operatingClass){

        _operatingClass = operatingClass;
    }

    public void render(){
        _operatingClass.process();
    }
}
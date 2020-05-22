package mypackage;  

import org.drombler.commons.fx.fxml.FXMLLoaders;  
...  

public class MyPane extends SomePane {  

    public MyPane(Foo foo) {
        super(foo);
        FXMLLoaders.loadRoot(this);  
    }  

    ...  
}
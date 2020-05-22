public class SomeClass { 
    private SomeOtherClass someOther = new SomeOtherClass(); 
    private AThirdClass thirdClass; 

    SomeClass( int x ) { 
        this.thirdClass = new AThirdClass( x ); 
    } 
}
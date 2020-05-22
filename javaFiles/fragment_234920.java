public enum ElementTypeEnum {
    UNASSIGNED,
    NOTE,
    REST
}

public class SimpleElementClass {
  private ElementTypeEnum _ElementType;

 public void setElementType(ElementTypeEnum n){
    _ElementType = n;
  }
  public ElementTypeEnum getElementType(){
    return _ElementType;
  }

  /* other members */
} // class SimpleElementClass

public class NoteClass extends SimpleElementClass { 
  /* other members */
} // class NoteClass

public class RestClass extends SimpleElementClass { 
  /* other members */
} // class RestClass
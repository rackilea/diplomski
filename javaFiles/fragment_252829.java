@XmlRootElement()
public class Foo {

   private customElement CustomElement;

   public CustomElement getCustomElement(){
       return customElement;
   }

   @XmlElement
   public void setCustomElement(CustomElement customElement){
       this.customElement = customElement;
   }
}
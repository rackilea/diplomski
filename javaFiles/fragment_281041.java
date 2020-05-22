@Override
  protected Object clone() throws CloneNotSupportedException {
     Orange orange = new Orange();
     //copy every basic variable
     orange.setPrice(price);

     //clone any Objects that have clone() method defined;
     orange.setImage(this.Image.clone()); //just an example because you don't have 1 in your code
     // for any objects that do not have clone() defined you have to copy each field manually
     GeneticStructure gn = new GeneticStructure();
     gn.setGeneticCode( this.geneticStructure.getGeneticCode());
     gn.setName( this.geneticStructure.getGeneticStructire());
     orange.setGeneticStructure( gn )

     return orange;
  }
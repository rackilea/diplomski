rule "Delete duplicated"
when 
  $f: Fruchtplanungsmodul()
  $c1: Crop() from $f.fruchtliste2F
  $c2: Crop(name == $c1.name) from $f.fruchtliste3F
then
  //If you want to remove the fact you have inserted too:
  delete($c2);

  //Remove the object from the array
  $f.deleteFrucht3($c2);
end
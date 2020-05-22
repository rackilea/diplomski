@XmlElement(name = "Pcpart")
public List<String> getPcParts(){
  if(Pcpart == null) {
    Pcpart = new ArrayList<String>();
  }
  return Pcpart;
}
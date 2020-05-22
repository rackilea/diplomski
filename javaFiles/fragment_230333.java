class Starship

   StringProperty name;
   ObjectProperty<CrewMember> captain;

   // possibly replace the following property with individual properties for roles
   // or use a ObservableMap<Role, CrewMember> instead???
   ObservableList<CrewMember> crew;
}

// could we make this immutable instead??? 
class CrewMember {
    StringProperty name;
    ObjectProperty<Image> image;
}
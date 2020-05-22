@Override
public int hashCode(){
     if (name == null){
         return 0;
     } else{
         return name.toLowerCase().hashCode();
     }
}
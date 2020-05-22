private List<String> validateList(List<String> validate){
   if(this.type == StudentType.Domestic && validate.isEmpty()){
        return validate;
    }
    else 
      if(this.type == StudentType.Domestic && !validate.isEmpty()){
        return Collections.emptyList();
   }
   return new ArrayList<String>(validate);
}
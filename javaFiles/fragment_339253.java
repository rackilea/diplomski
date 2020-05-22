<select class = "selectone">
  @for(gesture <- gesturesList){
      <option value = @gesture.id>
        @gesture.getName()
      </option>
  } 
  </select>
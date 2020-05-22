List<String> errorsList = new ArrayList<>();
List<FieldError> errors = result.getFieldErrors();
for (FieldError error : errors ) {
     System.out.println ("Validation error in field: " + error.getObjectName() 
                     + "! Validation error message: " + error.getDefaultMessage() 
                     + "! Rejected value:" + error.getRejectedValue());
          errorsList.add(error.getField() + " " + error.getDefaultMessage());
}

return ResponseEntity.badRequest().body(new StringResponseDTO(errorsList));
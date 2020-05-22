// prevent alphanumeric/special chars in numeric string (for backing field of type Long)
  binder.registerCustomEditor(Long.class, new CustomNumberEditor(Long.class, true) {
     @Override
     public void setAsText(String value) {
        if (value != null && !value.isEmpty() && CustomValidator.isNumeric(value)) {
           super.setAsText(value);
        } else {
           super.setAsText(null);
        }
     }
  });
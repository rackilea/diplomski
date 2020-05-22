public String getFullFieldName(String fieldName) {
+            if (parent instanceof AppendingValidatorContext) {
+                return parent.getFullFieldName("") + field + "." + fieldName;
+            }
         return field + "." + fieldName;
     }
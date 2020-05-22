778   public ErrorPageDescriptor getErrorPageDescriptorBySignifier(String signifier) {
779         for (ErrorPageDescriptor next : getErrorPageDescriptorsSet()) {
780             if (next.getErrorSignifierAsString().equals(signifier)) {
781                 return next;
782             }
783         }
784         return null;
785     }
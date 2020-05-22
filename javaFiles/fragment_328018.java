public ProcessorFactory getbyProduct(String product) {
   for (ProcessorFactory factory : values()) {
      if (factory.getProduct().equals(processor)) {
         return factory;
      }
   }
   return null; // or throw an exception
}
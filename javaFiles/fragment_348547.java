// Method 1    
bindingProvider.getRequestContext().put("mtom-enabled", Boolean.FALSE);
bindingProvider.getRequestContext().put("write.attachments", Boolean.FALSE);
// Method 2    
SOAPBinding binding = (SOAPBinding) (((BindingProvider) bindingProvider).getBinding());
    binding.setMTOMEnabled(false);
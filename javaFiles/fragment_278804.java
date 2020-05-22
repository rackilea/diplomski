if (item instanceof IAdaptable)
 {
   IAdaptable adaptable = (IAdaptable)item;

   IMarker marker = (IMarker)adaptable.getAdapter(IMarker.class);
 }
private void cancelDnD(TransferSupport support)
            {
                /*TransferSupport.setDNDVariables(Component component, DropTargetEvent event) 
                Call setDNDVariables(null, null) to free the component.
*/
                try
                {
                    Method m = support.getClass().getDeclaredMethod("setDNDVariables", new Class[] { Component.class, DropTargetEvent.class });
                    m.setAccessible(true);
                    m.invoke(support, null, null);
                    System.out.println("cancelledDnd");
                }
                catch (Exception e)
                {
                }
            }
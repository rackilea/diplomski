public static List<Component> getAllComponents(final Container c) {
        Component[] comps = c.getComponents();
        List<Component> compList = new ArrayList<Component>();
        for (Component comp : comps) {
          compList.add(comp);
          if (comp instanceof Container) {
            compList.addAll(getAllComponents((Container) comp));
          }


            if(comp instanceof JTextField){
                 System.out.println(comp);
            }

        }
        return compList;
    }
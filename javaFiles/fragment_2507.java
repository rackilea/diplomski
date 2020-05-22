Component[] comps = jScrollPane.getComponents();
ArrayList<JComponent> swingComps = new ArrayList<JComponent>();

for(Component comp : comps) {
     if(comp instanceof JComponent) {
          swingComps.add((JComponent) comp);
     }
}
public JPanel getPanelColliding(JPanel dragPanel, JPanel[] panels)
{
   Rectangle rDrag = dragPanel.getBounds();

   for (JPanel panel : panels){
     if (panel == dragPanel) continue;

     Rectangle r = panel.getBounds();
     if (r.insersects(rDrag))
         return r;
   }

   return null;
}
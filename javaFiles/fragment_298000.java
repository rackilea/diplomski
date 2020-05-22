function jSlider = testMouse2

hFig = figure('Position',[450 100 700 850]);

jSlider = javax.swing.JSlider;
jSlider.setMinimum(0);
jSlider.setMaximum(20);
jSlider.setMajorTickSpacing(5);
jSlider.setMinorTickSpacing(1);
jSlider.setPaintTicks(true);
jSlider.setPaintLabels(true);
jSlider.setSnapToTicks(true);
javacomponent(jSlider,[10,70,600,45]);

end
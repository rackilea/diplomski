p.translate(-cellBounds.x, -cellBounds.y);
Component label = rComponent.getComponentAt(p);

if (label == null) return super.getToolTipText();

newEvent = new MouseEvent(label, event.getID(),
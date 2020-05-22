if (component instanceof JComponent) {
        // Convert the event to the renderer's coordinate system
        Rectangle cellRect = getCellRect(hitRowIndex, hitColumnIndex, false);
        p.translate(-cellRect.x, -cellRect.y);
        MouseEvent newEvent = new MouseEvent(component, event.getID(),
                                  event.getWhen(), event.getModifiers(),
                                  p.x, p.y,
                                  event.getXOnScreen(),
                                  event.getYOnScreen(),
                                  event.getClickCount(),
                                  event.isPopupTrigger(),
                                  MouseEvent.NOBUTTON);

        tip = ((JComponent)component).getToolTipText(newEvent);
    }
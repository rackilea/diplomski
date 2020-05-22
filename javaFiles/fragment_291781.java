if (currentFrame.isMaximum() &&
        (f.getClientProperty("JInternalFrame.frameType") !=
        "optionDialog") ) {
                //Special case.  If key binding was used to select next
                //frame instead of minimizing the icon via the minimize
                //icon.
                if (!currentFrame.isIcon()) {
                    currentFrame.setMaximum(false);
                    if (f.isMaximizable()) {
                        if (!f.isMaximum()) {
                            f.setMaximum(true);
                        } else if (f.isMaximum() && f.isIcon()) {
                            f.setIcon(false);
                        } else {
                            f.setMaximum(false);
                        }
                    }
                }
            }
            if (currentFrame.isSelected()) {
                currentFrame.setSelected(false);
            }
        }

        if (!f.isSelected()) {
            f.setSelected(true);
        }
    } catch (PropertyVetoException e) {}
    if (f != currentFrame) {
        currentFrameRef = new WeakReference(f);
    }
}
...
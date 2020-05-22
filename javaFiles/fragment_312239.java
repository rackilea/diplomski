if (entryIf.getReturnType() != null &&
                            !entryIf.getReturnType().equals(Void.TYPE.getName()) &&
                            !entryIf.getReturnType().equals(Void.class.getName())) {
                        if (entryIf.getReturnType() instanceof String) {
                            String res = result + "";
                            if (res.indexOf("<html>") != -1) {
                                JFrame frame = displayHTMLJFrame(res, button.getText());
                                frame.setVisible(true);
                            }
                            else
                                fireChangedNotification(OPERATION_INVOCATION_EVENT, button, result);
                        } else
                            fireChangedNotification(OPERATION_INVOCATION_EVENT, button, result);
                    }
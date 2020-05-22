Overlay overlay = new Overlay();
overlay.setOverlayPosition(Overlay.Position.FOREGROUND);
overlay.setInputPDF(document1);
overlay.setAllPagesOverlayPDF(document2);

Map<Integer, String> ovmap = new HashMap<Integer, String>();            
overlay.overlay(ovmap);

document1.save("");

overlay.close();
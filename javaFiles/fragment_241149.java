if(SwingUtilities.isLeftMouseButton(e)) { //**Exception here**
    engine.markCell(i);
    ...
} else if(SwingUtilities.isRightMouseButton(e)) { //**or here**
    engine.showCell(i);
    ..
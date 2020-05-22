private boolean isPaint = true;
protected void paint(Graphics graphics) {
    if(!isPaint) return;
//  super.paint(graphics);      
    if (_currentFrame == _image.getFrameCount()-1) {
        graphics.setGlobalAlpha(0);
        isPaint = false;
    }
    graphics.drawImage(
                _image.getFrameLeft(_currentFrame),
                _image.getFrameTop(_currentFrame),
                _image.getFrameWidth(_currentFrame),
                _image.getFrameHeight(_currentFrame), _image,
                _currentFrame, 0, 0
            );
}
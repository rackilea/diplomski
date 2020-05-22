timeSlider.addMouseMotionListener(new MouseMotionAdapter() {
        @Override
        public void mouseDragged(MouseEvent arg0) {
            isDragging = true;
            try{
                int dv = timeSlider.getValue() * 1000;
                timeSlider.setValue(dv);
                Duration draggedVal = new Duration(dv);
                mediaPlayer.seek(draggedVal);
            }catch (Exception e3){

            } finally {
                isDragging = false;
            }
        }
    });
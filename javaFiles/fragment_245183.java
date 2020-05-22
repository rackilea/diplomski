canvas.
                saveState().
                setStrokeColor(modelButton.getBorderColor()).
                setLineWidth(1).
                rectangle(0, 0, occupiedArea.getBBox().getWidth(), occupiedArea.getBBox().getHeight()).
                stroke().
                setFillColor(modelButton.buttonBackgroundColor).
                rectangle(0.5f, 0.5f, occupiedArea.getBBox().getWidth() - 1, occupiedArea.getBBox().getHeight() - 1).
                fill().
                restoreState();
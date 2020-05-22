private void sortChildren() {
    int childCount = getChildCount();
    sortedIndexes.clear();
    int currentIndex=0;
    while (true) {
        if (currentIndex>=childCount) break;
        ArrayList<Integer> indexes = new ArrayList<>();
        indexes.add(currentIndex);
        for (int y=1;y<rowCount;y++) {
            int index = currentIndex + (y*columnCount);
            if (index<childCount) {
                indexes.add(index);
                maxVisibleRows = Math.max(indexes.size(), maxVisibleRows);
            } else break;
        }
        sortedIndexes.add(indexes);
        currentIndex++;
        if (currentIndex%columnCount==0) {
            currentIndex = (currentIndex-columnCount)+(rowCount*columnCount);
        }
    }
    maxVisibleColumns = sortedIndexes.size();
}

@Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    int widthMode = MeasureSpec.getMode(widthMeasureSpec);
    int heightMode = MeasureSpec.getMode(heightMeasureSpec);
    int width = 0;
    int height = 0;

    sortChildren();

    switch (heightMode) {
        case MeasureSpec.EXACTLY:
            height = MeasureSpec.getSize(heightMeasureSpec);
            cellSize = height/rowCount;
            break;
        case MeasureSpec.AT_MOST:
            height = MeasureSpec.getSize(heightMeasureSpec);
            cellSize = height/rowCount;
            height = Math.min(height,cellSize* maxVisibleRows);
            break;
        case MeasureSpec.UNSPECIFIED:
            cellSize = defaultCellSize;
            height = defaultCellSize* maxVisibleRows;
            break;
    }

    switch (widthMode) {
        case MeasureSpec.EXACTLY:
            width = MeasureSpec.getSize(widthMeasureSpec);
            break;
        case MeasureSpec.AT_MOST:
            width = Math.min(MeasureSpec.getSize(widthMeasureSpec),maxVisibleColumns*cellSize);
            break;
        case MeasureSpec.UNSPECIFIED:
            width = maxVisibleColumns*cellSize;
            break;
    }

    int childCount = getChildCount();
    for (int i=0;i<childCount;i++) {
        View view = getChildAt(i);
        int cellMeasureSpec = MeasureSpec.makeMeasureSpec(cellSize-cellPadding*2,MeasureSpec.EXACTLY);
        view.measure(cellMeasureSpec,cellMeasureSpec);
    }

    setMeasuredDimension(width,height);
}

@Override
protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    for (int i=0;i<rowCount;i++) {
        for (int y = 0; y < sortedIndexes.size(); y++) {
            ArrayList<Integer> indexes = sortedIndexes.get(y);
            if (i < indexes.size()) {
                maxVisibleRows = Math.max(maxVisibleRows, i + 1);
                View v = getChildAt(indexes.get(i));
                if (v == null) continue;
                int yOffset = (int)((1.0f*rowCount-maxVisibleRows)/2*cellSize);
                int newX = y * cellSize;
                int newY = i * cellSize + yOffset;
                v.layout(newX + cellPadding, newY + cellPadding, newX + cellSize - cellPadding, newY + cellSize - cellPadding);
            }
        }
    }
}
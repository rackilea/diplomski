@Override
public void setEvents(List<? extends Event> colorList){
    if(colorList!=null){
        paintList = new ArrayList<>(colorList.size());
        for(Event e: colorList){
            Paint eventPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            eventPaint.setStyle(Paint.Style.FILL);
            eventPaint.setColor(e.getColor()); // ONLY THIS LINE CHANGED
            paintList.add(eventPaint);
        }
        invalidate();
        requestLayout();
    }
}
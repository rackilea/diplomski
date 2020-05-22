@Override
protected void endDragging(MouseUpEvent event)
{
 int genericMargin = 60;

 int leftMargin = -(this.getOffsetWidth() - genericMargin);
 int lowerMargin = Window.getClientHeight() - genericMargin;
 int rightMargin = Window.getClientWidth() - genericMargin;
 int upperMargin = 0;

 if (this.getAbsoluteLeft() > rightMargin) 
 {this.setPopupPosition(rightMargin, this.getPopupTop()); }

 if (this.getAbsoluteLeft() < leftMargin) 
  { this.setPopupPosition(leftMargin, this.getPopupTop()); }

 if (this.getAbsoluteTop() > lowerMargin) 
 { this.setPopupPosition(this.getPopupLeft(), lowerMargin);}

 if (this.getAbsoluteTop() < upperMargin) 
 { this.setPopupPosition(this.getPopupLeft(), upperMargin);}

 super.endDragging(event);
}
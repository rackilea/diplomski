double slope = (startCell.getEast() - endCell.getEast());
if ( slope == 0 ){//prevent division by 0
    slope = startCell.getSouth() - endCell.getSouth();
}else{
    slope = (startCell.getSouth() - endCell.getSouth()) / slope;
}

return new HashCodeBuilder(43, 59)
   .append(this.startCell)
   .append(this.endCell)
   .append(slope)
   .toHashCode();
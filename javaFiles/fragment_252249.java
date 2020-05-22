double length = Math.sqrt(Math.pow(startCell.getSouth() - endCell.getSouth(), 2) + Math.pow(startCell.getEast() - endCell.getEast(), 2));
return new HashCodeBuilder(43, 59)
   .append(this.startCell)
   .append(this.endCell)
   .append(length)
   .toHashCode();
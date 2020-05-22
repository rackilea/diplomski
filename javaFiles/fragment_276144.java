public Leave(Parcel in)
{              
  this.id = in.readString();
  this.type = in.readString();
  this.status = in.readString();
  this.approver = in.readString();
}
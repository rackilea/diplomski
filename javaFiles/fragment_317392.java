boolean result;
if(this.southwest.longitude <= this.northeast.longitude){   
    result = this.southwest.longitude <= var1 && var1 <= this.northeast.longitude;
} else {
    result = this.southwest.longitude <= var1 || var1 <= this.northeast.longitude;
}
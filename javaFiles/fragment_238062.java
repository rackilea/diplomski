Intent intent = new Intent(this.ctx, Bluetooth_Activity.class);
   //use the putExtra to add more values
   intent.putExtra("lastname",violator.getLName());
   intent.putExtra("violation",violator.getViolation());
   //...and so on
   this.ctx.startActivity(intent);
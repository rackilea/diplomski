while ( this.latch.getCount() != 0 )
  {
     this.publishValue( ( int ) this.latch.getCount() );
  }
  this.latch.await();
  this.publishValue( ( int ) this.latch.getCount() );
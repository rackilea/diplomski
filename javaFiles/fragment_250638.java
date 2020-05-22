@Override
public boolean equals(Object o) { 
  System.out.println("in equals()");
  if (o instanceof Pair) { 
    Pair<?, ?> p1 = (Pair<?, ?>) o;
    if ( p1.Key_.equals( this.Key_ ) && p1.Value_.equals( this.Value_ ) ) { 
      return(true);
    }
  }
  return(false);
}
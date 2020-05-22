for( Iterator<Double> itr = grades.iterator(); itr.hasNext(); ) {
  Double grade = itr.next();

  //you might want to check for null
  if( grade < ave ){       
    itr.remove();
  }
}
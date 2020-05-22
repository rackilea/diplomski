if(stop>this.size() ){
throw new IndexOutOfBoundsException();
}
else
{
Iterator<E> iterator = iterator();

for (int j = 0; j <stop ; j++) {
    if(iterator.hasNext()){
     // Todo
     }else {
         break;
     }
  }
}
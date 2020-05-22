public Triangle(Object obj){
  if (obj instanceof Triangle){
      Triangle other = (Triangle) obj;
      this.p1 = new Point(other.p1);
      this.p2 = new Point(other.p2);
      this.p3 = new Point(other.p3);
  }
...
}
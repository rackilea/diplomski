public Object clone()
{
 B newB = new B(this.getName(), this.getLength());
 for(int i =0;i<newB.a.length;i++)
   {
      newB.a[i] = a[i];
    }
    return newB;
  }
class SecondInner extends FirstInner
        {

            public SecondInner(double r)
            {
                Outer.this.super(r);       //<-------------
            }

            public void showSum()
            {
                System.out.print("\nArea of circle = "
                  +(Math.pow(r, 2)*Math.PI)+"\n\n");
                }
            }
}
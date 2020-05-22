int[] approximate(int[] p, int[] p2, double dr, int l) { // l is the distance, dr is 0 for the beginning of the segment and 1 for the end
          double d=Math.sqrt(Math.pow(p[0]-p2[0], 2)+Math.pow(p[1]-p2[1], 2));
          double ix=p[0]+dr*(p2[0]-p[0]), iy=p[1]+dr*(p2[1]-p[1]);
          double x1=0, x2=0, y1=0, y2=0;
          if(p2[0]==p[0]) {
            x1=ix+l; x2=ix-l; y1=iy; y2=iy;
          }
          else {
          double m=1.0*(p2[1]-p[1])/(p2[0]-p[0]);
          if(Math.abs(m)==0) {
            x1=ix; x2=ix; y1=iy+l; y2=iy-l;
          }
          else {
            double m2=-1/m;
            double c=iy-m2*ix;
            double A=1+m2*m2, B=-2*(ix-m2*c+m2*iy), C=ix*ix+iy*iy+c*c-2*c*iy-l*l;
            x1=(-B+Math.sqrt(B*B-4*A*C))/(2*A); x2=(-B-Math.sqrt(B*B-4*A*C))/(2*A); y1=m2*x1+c; y2=m2*x2+c;
          }
          }
          int[] cp1={p2[0]-p[0], p2[1]-p[1]}, cp2={(int)x1-p[0], (int)y1-p[1]}, xy=new int[2];
          int cpp=compareAngles(cp1, cp2);
          if(cpp>0) { xy[0]=(int)x1; xy[1]=(int)y1; } else { xy[0]=(int)x2; xy[1]=(int)y2; }
          return xy;
  }

  void poly() {
    int[][] p={{100, 400}, {110, 440}, {250, 300}, {350, 400}, {300, 310}};
    BufferedImage bim=new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
    Graphics2D g=(Graphics2D)bim.getGraphics();
    g.setColor(Color.white);
    g.fillRect(0, 0, 500, 500);
    g.setStroke(new BasicStroke(5f));
    g.setColor(Color.black);
    Line2D.Double l1=new Line2D.Double(), l2=new Line2D.Double();
    int[] currentp=new int[2], lastp=new int[2];
    for(int i=0; i<p.length-1; i++) {
      g.setColor(Color.black);
      g.drawLine(p[i][0], p[i][1], p[i+1][0], p[i+1][1]);
      int[] p1=approximate(p[i], p[i+1], 0, 10), p2=approximate(p[i], p[i+1], 1, 10);
      g.setColor(Color.red);
      g.drawLine(p1[0], p1[1], p2[0], p2[1]);
      if(i==0) { l1=new Line2D.Double(p1[0], p1[1], p2[0], p2[1]); currentp[0]=p1[0]; currentp[1]=p1[1]; }
      else {
        l2=new Line2D.Double(p1[0], p1[1], p2[0], p2[1]);
        int[] pi=intersectionPoint(l1, l2);
        g.setColor(Color.green);
        g.fillOval(pi[0], pi[1], 5, 5);
        g.setColor(Color.yellow);
        g.drawLine(currentp[0], currentp[1], pi[0], pi[1]);
        currentp[0]=pi[0]; currentp[1]=pi[1];
        l1.setLine(l2);
      }
      if(i==p.length-2) { lastp[0]=p2[0]; lastp[1]=p2[1]; }
    }
    g.setColor(Color.yellow);
    g.drawLine(currentp[0], currentp[1], lastp[0], lastp[1]);
  }

  public int[] intersectionPoint(Line2D.Double l1, Line2D.Double l2) {
    return intersectionPoint((int)l1.getX1(), (int)l1.getY1(), (int)l1.getX2(), (int)l1.getY2(), (int)l2.getX1(), (int)l2.getY1(), (int)l2.getX2(), (int)l2.getY2());
  }

  public int[] intersectionPoint(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
    int[] xy={(int)(1.0*((x1*y2-y1*x2)*(x3-x4)-(x1-x2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4))),
                (int)(1.0*((x1*y2-y1*x2)*(y3-y4)-(y1-y2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4)))};
    return xy;
  }


  public int compareAngles(int[] a, int[] b) {
    int cp=a[0]*b[1]-a[1]*b[0];
    return -cp;
  }
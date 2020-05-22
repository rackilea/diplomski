public  void  mouseMoved(MouseEvent e) { 

        double distance1 = Math.pow((e.getX() - x1),2);
        double distance2 = Math.pow((e.getY() - y1),2); // Math.pow(a,b) == a^b (in a calculator)

        setdistance(Math.sqrt(distance1 + distance2));
        System.out.println(getdistance()); 
}
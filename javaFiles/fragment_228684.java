public void MousePressed(MouseEvent e){
            int mx = e.getX();
            int my = e.getY();
            System.out.println("2");
            if((screen ==0) && start2.contains(mx,my)){
                screen=1;
                System.out.println("1");
            }
        }
private final Set<Character> Keyspressed = new HashSet<Character>(); 

    public void keyPressed(KeyEvent e){
            pressed.add(e.getKeyChar());
            if (Keyspressed.size() > 1) {
    //size is greator than one which means you
    //have pressed more than one key. 
    //now your set contains all pressed keys. iterate it and fine out which was pressed.
                   foo(Keyspressed);
                    }
                }
    public void foo(Set<Character> Keyspressed){
    boolean Apressed = false;
    boolean Wpressed = false;
    boolean Spressed = false;
    boolean Dpressed = false;

      for(Character e : Keyspressed){
      if(e==KeyEvent.VK_A){
      Apressed = true; 
      }else if(e==KeyEvent.VK_S){
      Spressed = true;
      }else if(e==KeyEvent.VK_D){
      Dpressed = true; 
      }else if(e==KeyEvent.VK_W){
      Wpressed = true;
        }
      } 
      if(Apressed && Spressed){
      //your logic
         }

      }
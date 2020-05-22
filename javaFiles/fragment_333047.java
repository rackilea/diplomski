public void move(char dirrection){
    switch(dirrection){
       case 'U' : moveUp(); break;
       case 'D' : moveDown(); break;
       case 'L' : moveLeft(); break;
       case 'R' : moveRight(); break;
       default: System.out.println("can't move in dirrection: "+dirrection);
    }
}
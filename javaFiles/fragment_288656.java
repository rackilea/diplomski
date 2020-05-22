public void resize(int reSize){
    E[] tmp = (E[]) new Object[reSize];

       int current = front;
       for (int i = 0; i < count; i++)
          {
          tmp[i] = elements[current];
          current = (current + 1) % count;
          }
     elements = tmp;
     front = 0;
     back = count-1;
     capacity=reSize;
       }
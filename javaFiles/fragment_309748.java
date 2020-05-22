int x;
      int size;
      Random rnd =  new Random();
      Queue<Integer> queue = new ArrayDeque<Integer>();
      Queue<Integer> queue2 = new ArrayDeque<Integer>();

      for(int i=0;i<20;i++)
        queue2.add(rnd.nextInt(100));

      size = queue2.size();
      for(int i=0;i<size;i++)
      {
        x=queue2.remove();
        if(x%3==0)
          queue.add(x);
        else
          queue2.add(x); 
      }

      size = queue2.size();
      for(int i=0;i<size;i++)
      {
        x=queue2.remove();
        if(x%3==1)
          queue.add(x);
        else
          queue2.add(x);
      }

      size = queue2.size();
      for(int i=0;i<size;i++)
      {
        x=queue2.remove();
        if(x%3==2)
          queue.add(x);
        else 
          queue.add(x);     
      }

      System.out.println(queue.size());
      System.out.println(queue2.size());

      System.out.println("the size of queue is: " + queue.size());  
      while(!queue.isEmpty())
        System.out.print(queue.remove()+ " ");
      System.out.println("\n---------------------------------");
      while(!queue2.isEmpty())
        System.out.print(queue2.remove()+" ");
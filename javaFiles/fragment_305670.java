int num = front;

        for(int i = 0; i < count; i++){
            temp += "CircularQueue[" + num + "] = " + queue[num] +"\n";
            num = (num + 1) % queue.length;
        }
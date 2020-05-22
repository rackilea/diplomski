for(int i = front; i != rear; i = (i+1)%size ){
    if(queue[i][1] == '0'){
        tmp = queue[i][0];
        queue[i][0] = c;
        front = (i+1) % size;
        rear = i;
        break;
    } else {
        queue[i][1] = '0';
    }
}
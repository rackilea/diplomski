for(int i=VALUES.length-1; i>0; i--){
            int rand = (int) (Math.random()*i);
            char temp = VALUES[i];
            VALUES[i] = VALUES[rand];
            VALUES[rand] = temp;
    }
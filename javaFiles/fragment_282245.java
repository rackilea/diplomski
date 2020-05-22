private int group1, group2, group3, group4;
    private int total = 0;

        public void assignMembers()
        {
            group1 = (int)(Math.random()*6 + 1);
            group2 = (int)(Math.random()*6 + 1);
            group3 = (int)(Math.random()*6 + 1);
            group4 = (int)(Math.random()*6 + 1);
        }

        private void calc(int group)
        {
            switch (group){
                    case 3:
                      total += 2;
                      break;
                    case 5:
                      total += 4;
                      break;
            }
        }

        public void calculateSomething(){
            calc(group1);
            calc(group2);
            calc(group3);
            calc(group4);
        }
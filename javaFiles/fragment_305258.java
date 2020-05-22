Random randomno = new Random();

int r = randomno.nextInt(3);

TextView randomnumber = (TextView) findViewById(R.id.TVRno);

int[] arr = new int[2];

arr[0] = 0;

arr[1] = 2;

int z = 0;

            for(int i = 0; i < arr.length; i++){
                if(r == arr[i]){
                    z = randomno.nextInt(3);
                    i = 0;
                }
            }
randomnumber.setText("" + z);
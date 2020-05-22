public void run() {
            int[] arr =  new int [3];
            for(int i=0; i<arr.length;i++){
                arr[i]=i;
            }
            // arr is in run() method
            domore(arr);
            for(int i=0; i<arr.length;i++){
                System.out.println(arr[i]);
            }
        }

        private void domore(int[] arr) {
            // TODO Auto-generated method stub
            int [] att = new int [3];
            for(int i=0; i<att.length;i++){
                att[i]=77;
            }
            arr=att; // here scope of arr is local for domore() method only
            // so arr in run() method will not modified.
        }
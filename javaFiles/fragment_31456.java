DefaultTableModel model = new DefaultTableModel(ProcessArray(data,1),columnNames);

 public Object[][] ProcessArray(Object[][] arr,int colindex) {

            List points = Arrays.asList(arr);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                   points.remove(arr[i][colindex]);
                }
             }
             Object[][] returnData = (Object[][]) points.toArray();
             return returnData;

        }
int n = Integer.parseInt(tt.getText());
     for (int i=0;i<=ta.size()-n;i++){
         int c = n;
         String m = "";
         int e = 0 ;
         while(c>0){
             String t=(ta.get(e+i));
             m=m+t;
             e++;
             c--; 
         }
         ta1.add(m);
     }
     t3.setText(ta1.toString());
while(t-->0){
   StringTokenizer st = new StringTokenizer(br.readLine());
   int s = Integer.parseInt(st.nextToken());
   int k = Integer.parseInt(st.nextToken());
   // to take new line in input
   StringTokenizer arrInput = new StringTokenizer(br.readLine());
   int[] arr = new int[s];
   for(int i=0;i<s;i++){
       arr[i] = Integer.parseInt(arrInput.nextToken());
   }
   int[] answer = new int[s];

   for(int j=0; j<s;j++){
       answer[(j-k+s)%s]=arr[j];
   }
   for(int j=0;j<s;j++){
       arr[j] = answer[j];
   }
}
//all you need to do is print your arr array.